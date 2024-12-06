package com.example.batch.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CsvToDbService {

  public void execute() throws Exception {
    log.info("----------- START ----------- CsvToDbService ----------- START -----------");

    log.info(
        System.lineSeparator().repeat(3)
            + "***************************************************************************************"
            + System.lineSeparator()
            + "***                     ここにバッチの業務ロジックを記述する !!!                          ***"
            + System.lineSeparator()
            + "***               Business logic for the batch process goes here!                   ***"
            + System.lineSeparator()
            + "***************************************************************************************"
            + System.lineSeparator().repeat(3));

    log.info("-----------  END  ----------- CsvToDbService -----------  END  -----------");
  }
}
