# STUDENT COURSE MANAGEMENT
## Hibernate Relationships Project

This project demonstrates all 4 core Hibernate relationships:

- 🔗 OneToOne (Student ↔ Address)
- 🔁 OneToMany / ManyToOne (Department → Students)
- 🔄 ManyToMany (Student ↔ Course)

Built with:
- Java
- Hibernate (JPA)
- MySQL
- Maven
- DAO-Service layered architecture

---

## Features

- ✅ Add / View / View by ID — Student, Course, Department, Address
- 🔍 Fetch with relations (e.g. Student with Address, Department with Students)
- 🧱 Clean structure: Entity + DAO + Service + MainApp
- ⚙️ Config via `hibernate.cfg.xml`

---

## How to Run

1. Clone the repo  
2. Update DB creds in `hibernate.cfg.xml`
3. Create Database -- Run this in MySQL `CREATE DATABASE studentdb`
4. Run `Main.java`

---



