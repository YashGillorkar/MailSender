# **Automated Resume Submission Project**

This project automates the process of sending a resume to HR email addresses. It streamlines job applications by programmatically submitting your resume to multiple HR contacts.

## **Table of Contents**
- [Description](#description)
- [Configuration](#configuration)
- [Contributing](#contributing)

---

## **Description**

This project takes a resume file (e.g., PDF, DOCX) and a list of HR email addresses as input. It then sends the resume as an email attachment to each of the specified addresses using **Spring Boot, SMTP (Simple Mail Transfer Protocol), PostgreSQL, and RESTful APIs**.  

### **Technology Stack:**
- **Spring Boot** - Backend framework to handle RESTful APIs.
- **JavaMailSender (SMTP)** - Sends emails with attachments.
- **PostgreSQL** - Stores HR email contacts.
- **RESTful API** - Exposes endpoints to manage job applications.

### **Key Features:**
✅ Accepts **resume files (PDF, DOCX, etc.)**  
✅ Stores **HR email addresses** in a database  
✅ Uses **SMTP (Gmail, Outlook, etc.)** to send emails  
✅ Implements a **RESTful API** for managing resume submissions  
✅ **Error handling** and logging  

### **Important Considerations:**
⚠️ **Ethical Use:** Avoid spamming HR emails. Use only for legitimate job applications.  
⚠️ **Email Limits:** Be aware of email provider restrictions to avoid being flagged for spam.  
⚠️ **HR Preferences:** Some companies prefer applications through their online portals.  

---
