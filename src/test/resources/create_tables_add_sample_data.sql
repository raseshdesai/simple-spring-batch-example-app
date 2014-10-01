-- ========================================================================
-- Copyright 2012 the original author or authors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
--
--      http://www.apache.org/licenses/LICENSE-2.0
--
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
-- ========================================================================

-- Follow this 3-step process when adding custom/application specific tables/data


-- Step1: Clean up your tables, if exists
drop table SPRING_BATCH_SAMPLE_APP.CUSTOMER if exists;
drop table SPRING_BATCH_SAMPLE_APP.PURCHASE if exists;

-- Step2: Create Customer/Purchase Table
CREATE SCHEMA SPRING_BATCH_SAMPLE_APP AUTHORIZATION DBA;

CREATE TABLE SPRING_BATCH_SAMPLE_APP.CUSTOMER
(
  CUSTOMER_ID    INTEGER                       NOT NULL,
  CUSTOMER_NAME  VARCHAR(100)                  NOT NULL,
  EMAIL          VARCHAR(100)                  NOT NULL,
  PROCESSED      CHAR(1)                       DEFAULT 'N'                     NOT NULL
);
ALTER TABLE SPRING_BATCH_SAMPLE_APP.CUSTOMER ADD PRIMARY KEY (CUSTOMER_ID);

CREATE TABLE SPRING_BATCH_SAMPLE_APP.PURCHASE
(
  REF_NO               INTEGER                       NOT NULL,
  CUSTOMER_ID          INTEGER                       NOT NULL,
  PARTY                VARCHAR(100)                  NOT NULL,
  CATEGORY             VARCHAR(100)                  NOT NULL,
  AMOUNT               DOUBLE                        NOT NULL,
  DATE_ADDED           DATE                          DEFAULT SYSDATE                 NOT NULL,
  DATE_PROCESSED       DATE                          DEFAULT SYSDATE                 NOT NULL
);
ALTER TABLE SPRING_BATCH_SAMPLE_APP.PURCHASE ADD PRIMARY KEY (REF_NO);

-- Step3: Add Data to Customer/Purchase Table
INSERT INTO SPRING_BATCH_SAMPLE_APP.CUSTOMER(CUSTOMER_ID, CUSTOMER_NAME, EMAIL, PROCESSED) VALUES(1, 'John Doe', 'john.doe@email.com', 'N');
INSERT INTO SPRING_BATCH_SAMPLE_APP.CUSTOMER(CUSTOMER_ID, CUSTOMER_NAME, EMAIL, PROCESSED) VALUES(2, 'Jerry Chase', 'jerry.chase@email.com', 'N');
INSERT INTO SPRING_BATCH_SAMPLE_APP.CUSTOMER(CUSTOMER_ID, CUSTOMER_NAME, EMAIL, PROCESSED) VALUES(3, 'Sam', 'sam@email.com', 'N');
INSERT INTO SPRING_BATCH_SAMPLE_APP.CUSTOMER(CUSTOMER_ID, CUSTOMER_NAME, EMAIL, PROCESSED) VALUES(4, 'Jason', 'jason@email.com', 'N');

INSERT INTO SPRING_BATCH_SAMPLE_APP.PURCHASE (REF_NO, CUSTOMER_ID, PARTY, CATEGORY, AMOUNT) VALUES(1, 1, 'Macy Dept Store', 'CLOTHES', 500.67);
INSERT INTO SPRING_BATCH_SAMPLE_APP.PURCHASE (REF_NO, CUSTOMER_ID, PARTY, CATEGORY, AMOUNT) VALUES(2, 1, 'Walgreens', 'CLOTHES', 20.53);
INSERT INTO SPRING_BATCH_SAMPLE_APP.PURCHASE (REF_NO, CUSTOMER_ID, PARTY, CATEGORY, AMOUNT) VALUES(3, 2, 'Starbucks St Louis', 'FOOD', 3.46);
INSERT INTO SPRING_BATCH_SAMPLE_APP.PURCHASE (REF_NO, CUSTOMER_ID, PARTY, CATEGORY, AMOUNT) VALUES(4, 3, 'Walmart', 'FOOD', 13.96);
INSERT INTO SPRING_BATCH_SAMPLE_APP.PURCHASE (REF_NO, CUSTOMER_ID, PARTY, CATEGORY, AMOUNT) VALUES(5, 3, 'J C Penny', 'CLOTHES', 87.54);
INSERT INTO SPRING_BATCH_SAMPLE_APP.PURCHASE (REF_NO, CUSTOMER_ID, PARTY, CATEGORY, AMOUNT) VALUES(6, 3, 'Shell', 'GAS', 45.22);
INSERT INTO SPRING_BATCH_SAMPLE_APP.PURCHASE (REF_NO, CUSTOMER_ID, PARTY, CATEGORY, AMOUNT) VALUES(7, 4, 'BP', 'GAS', 95.34);