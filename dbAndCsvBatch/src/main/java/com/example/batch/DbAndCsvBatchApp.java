package com.example.batch;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * バッチ処理の流れは job登録 -> logic -> service -> repository となっている。
 *
 * <p>実行時引数にジョブ名とプロファイルを設定して起動することで、バッチジョブを実行することができる。
 *
 * <p>[intelliJの実行時パラメーターの例]
 *
 * <p>--spring.batch.job.name=CSV_TO_DB --spring.profiles.active=local
 *
 * <p>[terminalからGradleで実行する例]
 *
 * <p># ./gradlew bootJar
 *
 * <p># java -jar build/libs/id-platform-batch-*.jar --spring.batch.job.name=DB_TO_CSV
 * --spring.profiles.active=local
 */
@SpringBootApplication
public class DbAndCsvBatchApp {
  private static final Logger log = LoggerFactory.getLogger(DbAndCsvBatchApp.class);

  public static void main(String[] args) {
    logOnlyBatchDetails();

    System.exit(SpringApplication.exit(SpringApplication.run(DbAndCsvBatchApp.class, args)));
  }

  /**
   * バッチの起動引数をログ出力して確認できるようにする
   *
   * <p>Logs the batch startup arguments for verification.
   */
  private static void logOnlyBatchDetails() {
    String commandProp = System.getProperty("sun.java.command");
    log.info(
        "##### KEY:\"sun.java.command\", VALUE:\"{}\"", System.getProperty("sun.java.command"));
    String jobName = StringUtils.substringAfterLast(commandProp, "--spring.batch.job.name=");
    jobName = StringUtils.substringBefore(jobName, " ");
    String profile = StringUtils.substringAfterLast(commandProp, "--spring.profiles.active=");
    profile = StringUtils.substringBefore(profile, " ");
    log.info("##### Spring Batch ##### - Job: {}, Profile: {}", jobName, profile);
  }
}
