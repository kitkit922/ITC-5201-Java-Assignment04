# ITC-5201-Java-Assignment04

- Semester: #02
- Course: ITC-5201-Java
- Assignment: #04 - GUI Design, data validation, exception handling and Database
- Group: #03
- Member:
  - Ansh Bhardwaj
  - Tsz Kit Cheung(Kevin)
  - Wenhao Fang(Simon)

---

## Program Design

- Package `model`:

  - `Staff` class: the class that represents the data in database

  ```mermaid
  classDiagram

        class Staff{
            -ID: string
            -lastName: string
            -firstName: string
            -mi: string
            -address: string
            -city: string
            -state: string
            -telephone: string
            -email: string
            +toString():string
        }

  ```

---

- Package `controller`:

  - `StaffController` class: the class that queries data from the database and transmits to UI, as well as collects changes of data from UI and commits to the database.

  ```mermaid
  classDiagram

        class StaffController{
            -connection:Connection
            +isConnect():boolean
            +isUnique(id:string):boolean
            +getStaff(id:string):Staff
            +createStaff(staff:Staff):boolean
            +updateStaff(id:string, staff:Staff):boolean
        }

  ```

---

- `Response` class: the class that communicates between UI and Controller, providing a decoupling development to make UI and database independent from each other.

  ```mermaid
  classDiagram

        class Response{
              +status: string
              +message: string
              +data: Staff
        }

  ```

---

- Package `view`:

  - Design
    ![sample](./doc/ui.png)
  - Functionalities
    - validat input
    - display connection status
    - ActionListener
      - View: `.getStaff(id:string)`
      - Insert: `+createStaff(staff:Staff)`
      - Update: `+updateStaff(id:string, staff:Staff)`
      - Clear:`+deleteStaff(id:string)`

---

- `StaffDemo`: the class with main functioin, providing a uniform entry for debug

---

## Version 1.000

- Create github respository
- Create files architecture accordingly

---

## Version 1.001

- Add functionalities: `StaffController.java`

  - isConnect()
  - isUnique(id:string)
  - getStaff(id:string)
  - createStaff(staff:Staff)
  - updateStaff(id:string, staff:Staff)
  - deleteStaff(id:string)

- Add sample of adding actionListener in UI

---

## Version 1.011

- GUI design: `StaffUI.java`

---

## Version 1.012

- `StaffController.java` debug sql string.
- `Staff.java` add validation functionalities for each setter or getter.
- `StaffUI.java`:
  - add email test field
  - add view, insert, update, remove, clear action listener
  - add supportive function
  - add id validation functionality
- `doc/`
  - add ppt

---

[TOP](#itc-5201-java-assignment04)
