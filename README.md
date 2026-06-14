# Placement Preparation Portal

A full-stack web application to help students prepare for campus placements with DSA tracking and aptitude practice.

## 🚀 Live Demo

- **Frontend**: [https://placement-portal-hub.vercel.app](https://placement-portal-hub.vercel.app)
- **Backend API**: [https://placement-portal-production-df62.up.railway.app](https://placement-portal-production-df62.up.railway.app)

> **Note**: Backend may take 30-60 seconds to wake up if inactive (free tier hosting).

## 📋 Features

### 1. User Authentication
- Register new account
- Login with email/password
- Session management

### 2. DSA Tracker
- 50 curated LeetCode questions across 6 topics:
  - Arrays (10 questions)
  - Strings (10 questions)
  - LinkedList (8 questions)
  - Trees (8 questions)
  - Dynamic Programming (8 questions)
  - Graphs (6 questions)
- Filter questions by topic
- Mark questions as completed
- Track progress percentage
- Direct LeetCode links for solving

### 3. Aptitude Quiz
- 40 MCQ questions across 4 categories:
  - Mathematics (10 questions)
  - Reasoning (10 questions)
  - Verbal (10 questions)
  - Computer Science (10 questions)
- Category-wise filtering
- Instant scoring
- Answer validation (green/red feedback)

### 4. Dashboard
- Overall DSA progress
- Topic-wise completion statistics
- Total aptitude questions available

## 🛠️ Tech Stack

### Backend
- **Java 21** - Programming language
- **Spring Boot 3.3.2** - Framework
- **Spring Data JPA** - Database ORM
- **Spring Web** - REST APIs
- **MySQL** - Database

### Frontend
- **HTML5** - Structure
- **CSS3** - Styling (Flexbox/Grid)
- **JavaScript** - Dynamic content & API calls

### Deployment
- **Railway** - Backend hosting
- **Vercel** - Frontend hosting
- **GitHub** - Version control


## 🚦 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/register` | Register new user |
| POST | `/api/auth/login` | Login user |
| GET | `/api/dsa/all?email={email}` | Get all DSA questions |
| GET | `/api/dsa/topic/{topic}?email={email}` | Get questions by topic |
| PUT | `/api/dsa/complete/{id}?email={email}` | Mark question completed |
| GET | `/api/dsa/progress?email={email}` | Get user progress |
| GET | `/api/quiz/all` | Get all aptitude questions |
| GET | `/api/quiz/category/{category}` | Get questions by category |
| POST | `/api/quiz/submit` | Submit quiz answers |
| GET | `/api/dashboard/summary?email={email}` | Get dashboard stats |

## 💻 Local Setup

### Prerequisites
- Java 21 or higher
- MySQL 8.0
- Maven (or use included wrapper)
  
Author
Vinutha T 
