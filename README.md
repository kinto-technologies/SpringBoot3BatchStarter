Spring Batch3 Starter - Accelerate Your Spring Boot 3 Batch Development🚀
=============================
[![Github](https://img.shields.io/github/stars/KTC-YoheiMiyashita/SpringBoot3BatchStarter?logo=github&style=flat)](https://github.com/KTC-YoheiMiyashita/SpringBoot3BatchStarter)
[![GitHub Actions Build Status](https://github.com/KTC-YoheiMiyashita/SpringBoot3BatchStarter/actions/workflows/Java%20CI/badge.svg)](https://github.com/KTC-YoheiMiyashita/SpringBoot3BatchStarter/actions?query=workflow%3A%22Java+CI%22)
![Java 11+](https://img.shields.io/badge/Java-11%2B-blue)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)

# SpringBoot3BatchStarter

## Overview / 概要

This repository is a Spring Batch Starter Kit tailored for Spring Boot 3. It simplifies batch job development with the latest Spring Batch 5 features, ensuring compatibility with Spring Boot 3. Whether you’re upgrading from Spring Boot 2 or starting fresh, this project equips you to leverage the enhanced capabilities of Spring Batch.

このリポジトリは Spring Boot 3 および Spring Batch 5 の最新機能を活用して、バッチ処理の開発を効率化するためのスターターキットです。
Spring Boot 2からの移行、または新規開発において、最新のバッチ処理フレームワークをすぐに使い始めることができます。

### Key Highlights
- **Skeleton Batch Framework**: Quickly develop custom batch jobs with minimal setup.
- **DB to CSV Batch**: Export data from MySQL to CSV files seamlessly.
- **CSV to DB Batch**: Import CSV data into MySQL efficiently.

### 主な特徴
- **スケルトンバッチ**: 業務ロジックを追加するだけでバッチを簡単に構築可能。
- **DB to CSVバッチ**: MySQLからCSVファイルへのデータ出力します。where句を実行時引数で指定可能。
- **CSV to DBバッチ**: CSVデータをMySQLにバルクで登録します。

---

## 💡 Key Features / 特徴

### 🚀 Batch Development Made Simple
- **Spring Batch Framework**: Streamlined job and step management.
- **JOOQ ORM**: SQL-like query writing and entity generation, eliminating boilerplate code.
- **OpenCSV Integration**: Hassle-free CSV file handling.
- **Multi-Database Support**: H2 for metadata management and MySQL for business data.

### ⚙️ Flexibility and Optimization
- **Dynamic Configurations**: Environment-specific setups with profiles (local/server).
- **Customizable Batches**: Execute multiple jobs within a single JAR by passing runtime arguments.
- **Google Java Format**: Automated code formatting with Spotless.

### 💼 Future-Proof Design
- **Skeleton Batch Framework**: A template for creating new batch jobs.
- **Pre-configured Docker Environment**: Quickly set up a local MySQL database with Docker Compose.

---

## 🗂️ Project Structure / プロジェクト構成
```bash
.
├── compose.yaml
├── dbAndCsvBatch
│   ├── README.md
│   ├── build.gradle
│   └── src
│       ├── main
│       └── test
├── gradlew
├── init-scripts
│   ├── 1-create-table.sql
│   └── 2-insert-data.sql
└── skeletonBatch
    ├── README.md
    ├── build.gradle
    └── src
        ├── main
        └── test

```

## 🚀 Getting Started / はじめに
### Prerequisites
- Java 17+ for Spring Boot 3.
- Docker for setting up the MySQL environment.

### 1.	Clone the repository
```bash
git clone https://github.com/kinto-technologies/SpringBoot3BatchStarter.git
```

### 2. Build the skeleton batch
```bash
cd skeletonBatch
../gradlew
```

### 3. Run the skeleton batch
```bash
java -jar build/libs/skeletonBatch-*.jar
```

### 4. Set up the MySQL database for DB and CSV batch
```bash
docker compose up -d
```

### 5. Build the DB and CSV batch jobs
```bash
cd ../dbAndCsvBatch
../gradlew
```

### 6. Run Db to CSV Batch
```bash
java -jar build/libs/dbAndCsvBatch-*.jar --spring.batch.job.name=DB_TO_CSV --spring.profiles.active=local
```

### 7. Run CSV to DB Batch
```bash
java -jar build/libs/dbAndCsvBatch-*.jar --spring.batch.job.name=CSV_TO_DB --spring.profiles.active=local
```

#### With this Spring Batch Starter Kit, you can focus on your business logic while the framework handles the heavy lifting. Happy coding! 🎉
