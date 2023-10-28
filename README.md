# 2023-ITCS362-5

## T1: 'testOpenScreen'

### วัตถุประสงค์
การทดสอบนี้มีวัตถุประสงค์เพื่อตรวจสอบฟังก์ชัน `openScreen` เมื่อเปิดหน้าจอประเภทต่างๆ ที่แตกต่างกันและเปิดพร้อมกัน จะสามารถเปิดหน้าจอได้อย่างถูกต้อง

### Interface-Base

* Develop characteristics
    * C1 = ไม่มี Screen ใดเปิดอยู่
    * C2 = จำนวน Screen ที่สามารถเปิดได้

* Partition characteristics

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|----|----|
  | C1: ไม่มี Screen ใดเปิดอยู่     | True  | False  |
  | C2: จำนวน Screen ที่สามารถเปิดได้ | 0  | >=1  |

* Identify (possible) values

  | Characteristic                              | b1  | b2 |
  |--------------------------------------------|------------------------|---------------------------|
  | C1: ไม่มี Screen ใดเปิดอยู่           | is Empty  | is not Empty  |
  | C2: จำนวน Screen ที่สามารถเปิดอยู่ได้  | 0  | 1   |

### Functionality-Base

* Develop characteristics
    * C1 = ประเภทของ Screen ที่เปิดได้
    * C2 = สั่งเปิด Screen ได้อย่างถูกต้อง   

* Partition characteristics

  | Characteristic                                | b1            | b2        | b3          | b4           |
  |----------------------------------------------|---------------|------------|------------|--------------|
  | C1: ประเภทของ Screen ที่เปิดได้              | 1             | 2          | 3            | 4            |
  | C2: สั่งเปิด Screen ได้อย่างถูกต้อง         | True          | False      |             |              |


* Identify (possible) values

  | Characteristic                                | b1                 | b2        | b3          | b4           |
  |--------------------------------------------------|---------------|------------|------------|--------------|
  | C1: ประเภทของ Screen ที่เปิดได้                | MENU     | GAME   | DIFFICULTY   | THEME_SELECT    |
  | C2: สั่งเปิด Screen ได้อย่างถูกต้อง            | True          | False      |             |              |

### Input domain modelling
1. Identify testable functions
    * openScreen()
2. Identify parameters, return types, return values, and exceptional behavior
    * Parameters: screen
    * Return type: ไม่มีการคืนค่า (void)
    * Return value: ไม่มีการคืนค่า (void)
    * Exceptional behavior: ??
3. Model the input domain
    * Develop characteristics
        * C1 = ไม่มี Screen ใดเปิดอยู่
        * C2 = จำนวน Screen ที่สามารถเปิดได้
        * C3 = ประเภทของ Screen ที่เปิดได้
        * C4 = size ที่สั่งเปิด Screen   
    * Partition characteristics

      | Characteristic                                | b1            | b2        | b3          | b4           |
      |----------------------------------------------|---------------|------------|------------|--------------|
      | C1: ไม่มี Screen ใดเปิดอยู่              | True      | False  |             |              |
      | C2: จำนวน Screen ที่สามารถเปิดได้              | 0      | >=1  |             |              |
      | C3: ประเภทของ Screen ที่เปิดได้              | 1             | 2          | 3            | 4            |
      | C4: size ที่สั่งเปิด Screen         | True          | False      |             |              |
    * Identify (possible) values

      | Characteristic                                | b1            | b2        | b3          | b4           |
      |----------------------------------------------|---------------|------------|------------|--------------|
      | C1: ไม่มี Screen ใดเปิดอยู่เลย              | is Empty      | is not Empty  |             |              |
      | C2: จำนวน Screen ที่สามารถเปิดได้   | 0      | 2  |             |              |
      | C3: ประเภทของ Screen ที่เปิดได้          | MENU     | GAME   | DIFFICULTY   | THEME_SELECT    |
      | C4: size ที่สั่งเปิด Screen       | 0          | >=1      |             |              |

4. Combine partitions into tests
    * Assumption: choose Pair-Wise Coverage (PWC)
    * Test requirements -- number of tests (lower bound) = 4 * 2 = 8
       * C1:C2 -> (C1b1, C2b1) (C1b1, C2b2) (C1b2, C2b1) (C1b2, C2b2)
       * C1:C3 -> (C1b1, C3b1) (C1b1, C3b2) (C1b1, C3b3) (C1b1, C3b4) (C1b2, C3b1) (C1b2, C3b2) (C1b2, C3b3) (C1b2, C3b4)
       * C1:C4 -> (C1b1, C4b1) (C1b1, C4b2) (C1b2, C4b1) (C1b2, C4b2)
       * C2:C3 -> (C2b1, C3b1) (C2b1, C3b2) (C2b1, C3b3) (C2b1, C3b4) (C2b2, C3b1) (C2b2, C3b2) (C2b2, C3b3) (C2b2, C3b4)
       * C2:C4 -> (C2b1, C4b1) (C2b1, C4b2) (C2b2, C4b1) (C2b2, C4b2)
       * C3:C4 -> (C3b1, C4b1) (C3b1, C4b2) (C3b2, C4b1) (C3b2, C4b2) (C3b3, C4b1) (C3b3, C4b2) (C3b4, C4b1) (C3b4, C4b2)
       * Combination -> (C1b1, C2b1, C3b1, C4b1) (C1b1, C2b2, C3b3, C4b2) (C1b2, C2b1, C3b2, C4b1) (C1b2, C2b2, C3b2, C4b2) (C1b1, C2b2, C3b1, C4b2) (C1b1, C2b2, C3b2, C4b2) (C1b1, C2b1, C3b3, C4b1) (C1b1, C2b2, C3b4, C4b1)

5. Derive test values

   | Test | Screen           | numScreen          | Screen Type        | Size                | Expected Value  |
   |------|------------------|--------------------|--------------------|---------------------|-----------------|
   | T1   | is Empty         | 0                  | MENU               | 0                   |    False        |
   | T2   | is Empty         | 1                  | DIFFICULTY         | 1                   |    True         |
   | T3   | is not Empty     | 0                  | GAME               | 0                   |    False        |
   | T4   | is not Empty     | 1                  | GAME               | 2                   |    True         |
   | T5   | is Empty         | 1                  | MENU               | 1                   |    True         |
   | T6   | is Empty         | 1                  | GAME               | 1                   |    False        |
   | T7   | is Empty         | 0                  | DIFFICULTY         | 0                   |    False        |
   | T8   | is Empty         | 1                  | THEME_SELECT       | 0                   |    True         |


## T2: 'testOpenScreen'

### วัตถุประสงค์
เป็นการทดสอบการแปลงหน่วยจาก dp (density-independent pixels) เป็น px (pixels) ในแอปพลิเคชัน Android และเพื่อยืนยันว่าฟังก์ชัน testPxConversion() สามารถทำการแปลงค่าได้อย่างถูกต้อง

### Interface-Base

* Develop characteristics
    * C1 = DP Value ไม่เป็น 0 
    * C2 = ค่า PX ที่แปลงค่า

* Partition characteristics

  | Characteristic                    | b1    | b2    | b3    |
  |----------------------------------|-------|-------|-------|
  | C1: DP Value ไม่เป็น 0    | True   | False     |     |
  | C2: ค่า PX ที่แปลงค่า      | <=0   | 1     | >1    |

* Identify (possible) values

  | Characteristic                    | b1    | b2    | b3    |
  |----------------------------------|-------|-------|-------|
  | C1: DP Value ไม่เป็น 0    | 20   | 0     |     |
  | C2: ค่า PX ที่แปลงค่า      | -5  | 1.0  | 2.0  |

### Functionality-Base

* Develop characteristics
    * C1 = DP Value ที่ต้องการทดสอบ
    * C2 = ค่า PX ที่แปลงค่าเรียบร้อย

* Partition characteristics

  | Characteristic                               | b1            | b2              | b3          |
  |----------------------------------------------|---------------|-----------------|-------------|
  | C1: DP Value ที่ต้องการทดสอบ                   | <=0           | 1               | >1          |
  | C2: ค่า PX ที่แปลงค่าเรียบร้อย                     | < dpValue     | = dpValue       | > dpValue   |

* Identify (possible) values

  | Characteristic                               | b1  | b2  | b3  |
  |----------------------------------------------|----|----|----|
  | C1: DP Value ที่ต้องการทดสอบ                   | -5  | 1.0 | 2.0 |
  | C2: ค่า PX ที่แปลงค่าเรียบร้อย                     |-2.5 |  5  |  10 |

### Input domain modelling
1. Identify testable functions
    * px()
2. Identify parameters, return types, return values, and exceptional behavior
    * Parameters: dpValue
    * Return type: int
    * Return value: ค่า pixel ที่แปลงหน่วยแล้ว
    * Exceptional behavior: ??
3. Model the input domain
    * Develop characteristics
        * C1 = DP Value ไม่เป็น 0 
        * C1 = DP Value ที่ต้องการทดสอบ
        * C2 = ค่า PX ที่แปลงค่าเรียบร้อย

    * Partition characteristics

      | Characteristic                                | b1            | b2              | b3          |
      |----------------------------------------------|---------------|-----------------|-------------|
      | C1: DP Value ไม่เป็น 0       | True   | False  |      |
      | C2: DP Value ที่ต้องการทดสอบ        | <=0           | 1               | >1          |
      | C3: ค่า PX ที่แปลงค่าเรียบร้อย     | < dpValue     | = dpValue       | > dpValue   |

    * Identify (possible) values

      | Characteristic                                | b1  | b2  | b3  |
      |----------------------------------------------|----|----|----|
      | C1: DP Value ไม่เป็น 0           | 5  | 0 |  |
      | C2: DP Value ที่ต้องการทดสอบ             | 0  | 1   | 2   |
      | C3: ค่า PX ที่แปลงค่าเรียบร้อย          | -1 | 1   | 4  |

4. Combine partitions into tests
    * Assumption: choose Pair-Wise Coverage (PWC)
    * Test requirements -- number of tests (lower bound) = 3 * 3 = 9
      	* C1:C2 -> (C1b1, C2b1) (C1b1, C2b2) (C1b1, C2b3) (C1b2, C2b1) (C1b2, C2b2) (C1b2, C2b3)
      	* C1:C3 -> (C1b1, C3b1) (C1b1, C3b2) (C1b1, C3b3) (C1b2, C3b1) (C1b2, C3b2) (C1b2, C3b3) 
      	* C2:C3 -> (C2b1, C3b1) (C2b1, C3b2) (C2b1, C3b3) (C2b2, C3b1) (C2b2, C3b2) (C2b2, C3b3) (C2b3, C3b1) (C2b3, C3b2) (C2b3, C3b3)
      	* Combination -> (C1b1, C2b1, C3b2) (C1b1, C2b2, C3b2) (C1b1, C2b3, C3b2) (C1b2, C2b1, C3b1) (C1b2, C2b2, C3b1) (C1b2, C2b3, C3b1) (C1b1, C2b1, C3b3) (C1b1, C2b2, C3b3) (C1b1, C2b3, C3b3)

5. Derive test values

   | Test |     DP!=0     | DP Value | PX Value |  Expected Value |
   |------|---------------|----------|----------|-----------------|
   | T1   |     True      |  -5      |   -5     | true           |
   | T2   |     True      |  1       |   1      | true           |
   | T3   |     True      |  20      |   20     | true           |
   | T4   |     False     |  0       |   -5      | false            |
   | T5   |     False     |  1       |   -5      | Invalid         |
   | T6   |     False     |  20      |   -5      | Invalid         |
   | T7   |     True      |  -5      |   2      | false           |
   | T8   |     True      |  1       |   2      | false           |
   | T9   |     True      |  20      |   40      | false            |
   * T5 & T6 => Invalid Test เพราะว่า เงื่อนไข DP!=0 เป็น False ทำให้ไม่สามารถใส่ค่าอื่นได้นอกจาก 0

