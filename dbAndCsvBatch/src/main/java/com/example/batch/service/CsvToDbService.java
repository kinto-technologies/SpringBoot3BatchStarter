package com.example.batch.service;

import com.example.batch.enums.BatchResult;
import com.example.batch.jooq.tables.records.MemberRecord;
import com.example.batch.repository.MemberRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CsvToDbService {

  private final MemberRepository memberRepository;

  /**
   * CSVを読み取って、DBに流し込む
   *
   * <p>Reads data from a CSV file and inserts it into the database.
   */
  public BatchResult execute(String csvFilePath) throws Exception {

    try {
      List<MemberRecord> memberRecords = loadCsvData(csvFilePath);

      if (!memberRecords.isEmpty()) {
        memberRepository.bulkInsert(memberRecords);
        log.info("Successfully inserted {} records into the database.", memberRecords.size());
      } else {
        log.warn("No data found in the CSV file to insert.");
        return BatchResult.NODATA;
      }

    } catch (IOException e) {
      log.error("Failed to read the CSV file: {}", csvFilePath, e);
      throw e;
    } catch (Exception e) {
      log.error("An error occurred while processing the batch job.", e);
      throw e;
    }

    return BatchResult.SUCCESS;
  }

  private List<MemberRecord> loadCsvData(String csvFilePath)
      throws IOException, CsvValidationException {
    File csvFile = new File(csvFilePath);
    if (!csvFile.exists()) {
      log.error("CSV file does not exist at path: {}", csvFilePath);
      throw new FileNotFoundException(csvFilePath);
    }

    List<MemberRecord> memberRecords = new ArrayList<>();
    try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
      String[] header = reader.readNext();
      if (header == null) {
        log.warn("The CSV file is empty. Processing will be terminated.");
        return memberRecords;
      }

      String[] line;
      while ((line = reader.readNext()) != null) {
        MemberRecord memberRecord = new MemberRecord();
        memberRecord.setType(Byte.valueOf(line[1]));
        memberRecord.setName(line[2]);
        memberRecord.setEmail(line[3]);
        memberRecord.setPhone(line[4]);
        memberRecord.setAddress(line[5]);
        memberRecord.setDeleteFlag(Byte.valueOf(line[6]));
        memberRecords.add(memberRecord);
      }
    }

    log.info("Loaded {} records from the CSV file.", memberRecords.size());
    return memberRecords;
  }
}
