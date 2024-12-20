# Spring Batch 5 Starter

**Accelerate Your Spring Boot 3 Batch Development** 🚀


[![GitHub stars](https://img.shields.io/github/stars/KTC-YoheiMiyashita/SpringBoot3BatchStarter?style=social)](https://github.com/KTC-YoheiMiyashita/SpringBoot3BatchStarter/stargazers)
[![Build](https://github.com/kinto-technologies/SpringBoot3BatchStarter/actions/workflows/build.yml/badge.svg)](https://github.com/kinto-technologies/SpringBoot3BatchStarter/actions/workflows/build.yml)
![Java 21](https://img.shields.io/badge/Java-21%2B-blue)
[![License: Apache 2.0](https://img.shields.io/badge/License-Apache%202.0-CC2233.svg)](https://opensource.org/licenses/Apache-2.0)

## 🌐 Language Support
🇯🇵 日本語版 README は [こちら](README.ja.md).

## 🔍 Overview

This comprehensive starter kit is designed specifically for **Spring Boot 3** and **Spring Batch 5**, offering a production-ready foundation for enterprise batch processing applications. It incorporates industry best practices and leverages the latest Spring framework features to accelerate your batch development process.

## ⭐ Core Features
### 🏗️ Foundation Components

- **Production-Ready Batch Framework**: Pre-configured skeleton structure for rapid development.
- **Database Operations**:
  - Efficient DB-to-CSV export with dynamic query support
  - High-performance CSV-to-DB import with bulk operations
- **Enterprise-Grade Architecture**: Built with scalability and maintainability in mind

## 🛠️  Technical Capabilities
- **Advanced Spring Integration**
  - Robust Spring Batch job and step management
  - Type-safe SQL queries with JOOQ ORM
  - Seamless CSV processing with OpenCSV
- **Dual Database Configuration**
  - H2 In-Memory Database for batch metadata
  - MySQL for business data processing

## 💻 Development Experience
- **Dynamic Configuration**
  - Environment-specific profiles (local/server)
  - Runtime-configurable job execution
  - Flexible query customization through arguments
- **Code Quality Tools**
  - Automated formatting with Google Java Format (Spotless)
  - Static analysis via Spotbugs
  - Test coverage reporting with Jacoco
  - Integrated CI pipeline

## 🚢 DevOps Ready
- **Containerization**: Docker support with ready-to-use MySQL configuration
- **CI/CD Integration**: GitHub Actions workflows included
- **Simplified Build Process**: Single-command builds generating production-ready JARs

---

## 📁 Project Structure
```text
.
├── gradlew
├── settings.gradle
├── compose.yaml
├── init-scripts
│   ├── 1-create-table.sql
│   └── 2-insert-data.sql
├── dbAndCsvBatch
│   ├── README.md
│   ├── build.gradle
│   └── src
│       ├── main
│       └── test
└── skeletonBatch
    ├── README.md
    ├── build.gradle
    └── src
        ├── main
        └── test
```

## 🚀 Quick Start Guide

### 1.	Clone the repository
```bash
git clone https://github.com/kinto-technologies/SpringBoot3BatchStarter.git
```

### 2. Build Skeleton Batch
```bash
cd skeletonBatch
../gradlew
```

### 3. Execute Skeleton Batch
```bash
java -jar build/libs/skeletonBatch-*.jar
```

### 4. Initialize Database
```bash
docker compose up -d
```

### 5. Build Data Processing Jobs
```bash
cd ../dbAndCsvBatch
../gradlew
```

### 6. Run Database Export
```bash
java -jar build/libs/dbAndCsvBatch-*.jar --spring.batch.job.name=DB_TO_CSV --spring.profiles.active=local
```

### 7. Run Database Import
```bash
java -jar build/libs/dbAndCsvBatch-*.jar --spring.batch.job.name=CSV_TO_DB --spring.profiles.active=local
```

> **Note**: Docker installation is required for database setup.

## ♻️ Adaptability
The starter kit is designed for easy customization. Simply modify the database configurations and CSV mappings to align with your specific requirements, and you're ready to start processing your business data.

## 📜 License
Licensed under the **[Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)**.  

Copyright © 2024 KINTO Technologies Corporation