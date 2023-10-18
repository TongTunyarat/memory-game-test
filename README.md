# 2023-ITCS362-5

## T1: 'testOpenScreen'

### วัตถุประสงค์
การทดสอบนี้มีวัตถุประสงค์เพื่อตรวจสอบฟังก์ชัน `openScreen` เมื่อเปิดหน้าจอประเภทต่างๆ ที่แตกต่างกันและเปิดพร้อมกัน จะสามารถเปิดหน้าจอได้อย่างถูกต้อง

### Interface-Base

* Develop characteristics
    * C1 = สถานะการเปิดหน้าจอครั้งแรก (ไม่มีหน้าจอใดเปิดอยู่)
    * C2 = สถานะการเปิดหน้าจอที่มีหน้าจออื่นเปิดอยู่แล้ว

* Partition characteristics

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|----|----|
  | C1: สถานะการเปิดหน้าจอครั้งแรก     | True  | False  |
  | C2: สถานะการเปิดหน้าจอที่มีหน้าจออื่นเปิดอยู่แล้ว | True  | False  |

* Identify (possible) values

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|------------------------|---------------------------|
  | C1: สถานะการเปิดหน้าจอครั้งแรก           | มีหน้าจอเปิด  | ไม่มีหน้าจอเปิด  |
  | C2: สถานะการเปิดหน้าจอที่มีหน้าจออื่นเปิดอยู่แล้ว  | มีหน้าจอเปิด  | ไม่มีหน้าจอเปิด  |

### Functionality-Base

* Develop characteristics
    * C1 = ไม่มี Screen ใดเปิดอยู่เลย
    * C2 = เปิด Screen อย่างน้อย 1 ตัว 
    * C3 = สั่งเปิด Screen ได้อย่างถูกต้อง   

* Partition characteristics

  | Characteristic                                | b1            | b2        | b3          | b4           |
  |----------------------------------------------|---------------|------------|------------|--------------|
  | C1: ไม่มี Screen ใดเปิดอยู่เลย              | True      | False  |             |              |
  | C2: เปิด Screen อย่างน้อย 1 ตัว              | 1             | 2          | 3            | 4            |
  | C3: สั่งเปิด Screen ได้อย่างถูกต้อง         | True          | False      |             |              |


* Identify (possible) values

  | Characteristic                                | b1                 | b2        | b3          | b4           |
  |--------------------------------------------------|---------------|------------|------------|--------------|
  | C1: ไม่มี Screen ใดเปิดอยู่เลย                     | is Empty      | is not Empty  |             |              |
  | C2: เปิด Screen อย่างน้อย 1 ตัว                | MENU     | MENU and GAME   | MENU and GAME and DIFFICULTY   | MENU and GAME and DIFFICULTY and THEME_SELECT    |
  | C3: สั่งเปิด Screen ได้อย่างถูกต้อง            | True          | False      |             |              |

### Input domain modelling
1. Identify testable functions
    * testOpenScreen()
2. Identify parameters, return types, return values, and exceptional behavior
    * Parameters: screen
    * Return type: ไม่มีการคืนค่า (void)
    * Return value: ไม่มีการคืนค่า (void)
    * Exceptional behavior: ??
3. Model the input domain
    * Develop characteristics
        * C1 = ไม่มี Screen ใดเปิดอยู่เลย   
        * C2 = เปิด Screen อย่างน้อย 1 ตัว
        * C3 = สั่งเปิด Screen ได้อย่างถูกต้อง
    * Partition characteristics

      | Characteristic                                | b1            | b2        | b3          | b4           |
      |----------------------------------------------|---------------|------------|------------|--------------|
      | C1: ไม่มี Screen ใดเปิดอยู่เลย              | True      | False  |             |              |
      | C2: เปิด Screen อย่างน้อย 1 ตัว              | 1             | 2          | 3            | 4            |
      | C3: สั่งเปิด Screen ได้อย่างถูกต้อง         | True          | False      |             |              |
    * Identify (possible) values

      | Characteristic                                | b1            | b2        | b3          | b4           |
      |----------------------------------------------|---------------|------------|------------|--------------|
      | C1: ไม่มี Screen ใดเปิดอยู่เลย              | is Empty      | is not Empty  |             |              |
      | C2: เปิด Screen อย่างน้อย 1 ตัว              | MENU     | MENU and GAME   | MENU and GAME and DIFFICULTY   | MENU and GAME and DIFFICULTY and THEME_SELECT    |
      | C3: สั่งเปิด Screen ได้อย่างถูกต้อง         | True          | False      |             |              |

4. Combine partitions into tests
    * Assumption: choose Pair-Wise Coverage (PWC)
    * Test requirements -- number of tests (lower bound) = 4 * 2 = 8
       * C1:C2 -> (C1b1, C2b1) (C1b1, C2b2) (C1b1, C2b3) (C1b1, C2b4) (C1b2, C2b1) (C1b2, C2b2) (C1b2, C2b3) (C1b2, C2b4)
       * C1:C3 -> (C1b1, C3b1) (C1b1, C3b2) (C1b2, C3b1) (C1b2, C3b2)
       * C2:C3 -> (C2b1, C3b1) (C2b1, C3b2) (C2b2, C3b1) (C2b2, C3b2) (C2b3, C3b1) (C2b3, C3b2) (C2b4, C3b1) (C2b4, C3b2)
       * Combination -> (C1b1, C2b1, C3b1) (C1b1, C2b2, C3b1) (C1b1, C2b3, C3b1) (C1b1, C2b4, C3b1) (C1b2, C2b1, C3b2) (C1b2, C2b2, C3b2) (C1b2, C2b3, C3b2) (C1b2, C2b4, C3b2)

5. Derive test values

   | Test | Screen       | Open Screen Type    | Correct  | Expected Value |
   |------|------------------|--------------------|---------------------|-----------------|
   | T1   | is Empty         | GAME               | True                | Pass       |
   | T2   | is Empty         | MENU and GAME      | True               | Pass       |
   | T3   | is Empty         | MENU and GAME and DIFFICULTY             | True                |     Pass   |
   | T4   | is Empty         | MENU and GAME and DIFFICULTY and THEME_SELECT | True               | Pass       |
   | T5   | is not Empty         | GAME         | False                | Fail       |
   | T6   | is not Empty         | MENU and GAME         | False               | Fail       |
   | T7   | is not Empty         | MENU and GAME and DIFFICULTY        | False                | Fail |
   | T8   | is not Empty         | MENU and GAME and DIFFICULTY and THEME_SELECT        | False               |   Fail     |


## T2: 'testOpenScreen'

### วัตถุประสงค์
เป็นการทดสอบการแปลงหน่วยจาก dp (density-independent pixels) เป็น px (pixels) ในแอปพลิเคชัน Android และเพื่อยืนยันว่าฟังก์ชัน testPxConversion() สามารถทำการแปลงค่าได้อย่างถูกต้อง

### Interface-Base

* Develop characteristics
    * C1 = DP Value ที่ต้องการทดสอบ
    * C2 = PX Value ที่ได้

* Partition characteristics

  | Characteristic                    | b1    | b2    | b3    |
  |----------------------------------|-------|-------|-------|
  | C1: DP Value ที่ต้องการทดสอบ    | <=0   | 1     | >1    |
  | C2: PX Value ที่ได้             | <=0   | 1     | >1    |

* Identify (possible) values

  | Characteristic                    | b1    | b2    | b3    |
  |----------------------------------|-------|-------|-------|
  | C1: DP Value ที่ต้องการทดสอบ    | 0.5   | 1.0     | 2.0    |
  | C2: PX Value ที่ได้             | 0.5  | 1.0  | 2.0  |

### Functionality-Base

* Develop characteristics
    * C1 = Density value ที่อ่านค่ามา
    * C2 = DP Value ที่ต้องการทดสอบ
    * C3 = ค่า PX ที่แปลงค่าเรียบร้อย

* Partition characteristics

  | Characteristic                                | b1            | b2              | b3          |
  |----------------------------------------------|---------------|-----------------|-------------|
  | C1: Density value ที่อ่านค่ามา       | Low Density   | Medium Density  | High Density |
  | C2: DP Value ที่ต้องการทดสอบ        | <=0           | 1               | >1          |
  | C3: ค่า PX ที่แปลงค่าเรียบร้อย     | < dpValue     | = dpValue       | > dpValue   |

* Identify (possible) values

  | Characteristic                                | b1  | b2  | b3  |
  |----------------------------------------------|----|----|----|
  | C1: Density value ที่อ่านค่ามา          | 0.5  | 1.0 | 2.0 |
  | C2: DP Value ที่ต้องการทดสอบ             | -5  | 1   | 5   |
  | C3: ค่า PX ที่แปลงค่าเรียบร้อย          | -2.5 | 5   | 10  |

### Input domain modelling
1. Identify testable functions
    * testPxConversion()
2. Identify parameters, return types, return values, and exceptional behavior
    * Parameters: dpValue
    * Return type: int
    * Return value: ค่า pixel ที่แปลงหน่วยแล้ว
    * Exceptional behavior: ??
3. Model the input domain
    * Develop characteristics
        * C1 = Density value ที่อ่านค่ามา
        * C2 = DP Value ที่ต้องการทดสอบ
        * C3 = ค่า PX ที่แปลงค่าเรียบร้อย

    * Partition characteristics

      | Characteristic                                | b1            | b2              | b3          |
      |----------------------------------------------|---------------|-----------------|-------------|
      | C1: Density value ที่อ่านค่ามา       | Low Density   | Medium Density  | High Density |
      | C2: DP Value ที่ต้องการทดสอบ        | <=0           | 1               | >1          |
      | C3: ค่า PX ที่แปลงค่าเรียบร้อย     | < dpValue     | = dpValue       | > dpValue   |

    * Identify (possible) values

      | Characteristic                                | b1  | b2  | b3  |
      |----------------------------------------------|----|----|----|
      | C1: Density value ที่อ่านค่ามา          | 0.5  | 1.0 | 2.0 |
      | C2: DP Value ที่ต้องการทดสอบ             | -5  | 1   | 5   |
      | C3: ค่า PX ที่แปลงค่าเรียบร้อย          | -2.5 | 5   | 10  |

4. Combine partitions into tests
    * Assumption: choose Pair-Wise Coverage (PWC)
    * Test requirements -- number of tests (lower bound) = 3 * 3 = 9
      	* C1:C2 -> (C1b1, C2b1) (C1b1, C2b2) (C1b1, C2b3) (C1b2, C2b1) (C1b2, C2b2) (C1b2, C2b3) (C1b3, C2b1) (C1b3, C2b2) (C1b3, C2b3)
      	* C1:C3 -> (C1b1, C3b1) (C1b1, C3b2) (C1b1, C3b3) (C1b2, C3b1) (C1b2, C3b2) (C1b2, C3b3) (C1b3, C3b1) (C1b3, C3b2) (C1b3, C3b3)
      	* C2:C3 -> (C2b1, C3b1) (C2b1, C3b2) (C2b1, C3b3) (C2b2, C3b1) (C2b2, C3b2) (C2b2, C3b3) (C2b3, C3b1) (C2b3, C3b2) (C2b3, C3b3)
      	* Combination -> (C1b1, C2b1, C3b1) (C1b1, C2b1, C3b2) (C1b1, C2b1, C3b3) (C1b2, C2b2, C3b1) (C1b2, C2b2, C3b2) (C1b2, C2b2, C3b3) (C1b3, C2b3, C3b1) (C1b3, C2b3, C3b2) (C1b3, C2b3, C3b3)

5. Derive test values

   | Test | Density value | DP Value | PX Value | Expected Value |
   |------|---------------|----------|----------|-----------------|
   | T1   | 0.5           | -5       | -10      | fail            |
   | T2   | 0.5           | -5       | -5       | fail            |
   | T3   | 0.5           | -5       | -2.5     | pass            |
   | T4   | 1.0           | 1        | 0        | fail            |
   | T5   | 1.0           | 1        | 1        | pass            |
   | T6   | 1.0           | 1        | 2        | fail            |
   | T7   | 2.0           | 5        | 1        | fail            |
   | T8   | 2.0           | 5        | 5        | fail            |
   | T9   | 2.0           | 5        | 10       | pass            |

