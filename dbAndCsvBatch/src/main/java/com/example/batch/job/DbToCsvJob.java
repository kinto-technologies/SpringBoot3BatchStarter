package com.example.batch.job;

import com.example.batch.logic.DbToCsvLogic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class DbToCsvJob {

  private final DbToCsvLogic logic;

  /** 実行時引数で入力するジョブ名は、このstrJobNameと一致する必要がある */
  private static final String BATCH_JOB_NAME = "DB_TO_CSV";

  @Bean("DB_TO_CSV")
  public Job sample(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
    log.info("----------- START ----------- DbToCsvJob ----------- START -----------");
    Step myStep =
        new StepBuilder(BATCH_JOB_NAME + "-step", jobRepository)
            .tasklet(logic, transactionManager)
            .build();

    Job myJob =
        new JobBuilder(BATCH_JOB_NAME, jobRepository)
            .incrementer(new RunIdIncrementer())
            .listener(BATCH_JOB_NAME)
            .start(myStep)
            .build();
    log.info("-----------  END  ----------- DbToCsvJob -----------  END  -----------");

    return myJob;
  }
}
