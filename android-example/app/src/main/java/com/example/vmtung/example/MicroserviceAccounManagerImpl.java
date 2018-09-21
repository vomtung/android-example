package au.com.linearfinancial.bpms.microservice.account;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linear.common.dto.ApplicationDTO;
import com.linear.common.jsonapi.ApiError;
import com.linear.common.jsonapi.ApiResult;
import com.linear.common.jsonapi.ApiSuccessResult;

import au.com.linearfinancial.bpms.domain.entity.Application;
import au.com.linearfinancial.bpms.domain.entity.LegalEntity;
import au.com.linearfinancial.bpms.domain.entity.util.ApplicationTypeNameEnum;
import au.com.linearfinancial.bpms.microservice.MicroserviceMessagePublisher;
import au.com.linearfinancial.bpms.microservice.dto.CreateAccountResponseDto;
import au.com.linearfinancial.bpms.microservice.utils.MicroserviceUtils;
import au.com.linearfinancial.bpms.microservice.validator.MicroserviceValidator;
import au.com.linearfinancial.bpms.service.application.ApplicationServiceImpl;

@Service("microserviceAccounManagerImpl")
public class MicroserviceAccounManagerImpl implements MicroserviceAccountManager
{
    private final static Logger log = Logger.getLogger(MicroserviceAccounManagerImpl.class);

    private static final ObjectMapper jsonMapper = new ObjectMapper();

    @Autowired
    private ApplicationContext app;

    @Autowired
    private MicroserviceMessagePublisher msgPublisher;

    @Autowired
    private MicroserviceValidator microserviceValidator;
    
    @Autowired
    private ApplicationServiceImpl applicationService;

    @Override
    public void handleAccountCreateRequest(ApiSuccessResult<?> createRequest)
    {
        try
        {
            ApplicationDTO applicationDto = jsonMapper.convertValue(createRequest.getData(), ApplicationDTO.class);
            log.info("handleAccountCreateRequest " + applicationDto);
            
            // validation
            List<ApiError> errors = microserviceValidator.validate(applicationDto);
            if (!CollectionUtils.isEmpty(errors))
            {
                ApiResult<?> result = MicroserviceUtils.multipleErrors(errors, createRequest.getMeta());
                msgPublisher.publishAccountResult(result);
            }
            else
            {
                ApplicationTypeNameEnum applicationType = ApplicationTypeNameEnum.getByName(applicationDto.getApplicationTypeName());
                final AccountMicroservice accountMicroservice = app.getBean(applicationType.getServiceName(), AccountMicroservice.class);
                
                // Transform into approved application entity
                Application application = accountMicroservice.createApprovedApplication(applicationDto);
                log.info("Application created id = " + application.getId());

                // Convert to legal entity
                LegalEntity legalEntity = applicationService.convertToLegalEntity(application, applicationType);
                log.info("LegalEntity created id = " + legalEntity.getId());

                // Complete application
                application = applicationService.completeApplication(application);

                // Create success response
                CreateAccountResponseDto createdAccount = new CreateAccountResponseDto();
                createdAccount.setCode(legalEntity.getCode());
                ApiResult<?> result = new ApiSuccessResult<>(createdAccount);
                result.setMeta(createRequest.getMeta());
                msgPublisher.publishAccountResult(result);
            }
        }
        catch (Exception ex)
        {
            log.error("Failed to handleAccountCreateRequest " + createRequest, ex);
            ApiResult<?> result = MicroserviceUtils.singleError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), null, ex.getMessage(),
                                                   createRequest.getMeta());
            msgPublisher.publishAccountResult(result);
        }
    }
}