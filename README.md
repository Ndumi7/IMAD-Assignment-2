# 📚 Quiztory

Quiztory is a simple flashcard-based quiz app designed to help users learn historical facts in a fun and interactive way. Built with Kotlin and Android Studio, the app uses a minimalist design and clear UI to enhance learning through True/False questions, and post-quiz 
reviews.
---

## 🎯 Features

- ✅ True/False flashcard-style questions
- 🔄 Next button to progress through questions
- 🧠 Immediate feedback on answer correctness (shown after pressing "Next")
- 🏁 Final score screen with personalized messages based on performance
- 🔍 Review screen to compare user's answers with correct answers

---

## 🧪 How It Works

1. **Flashcard Screen:**
   - Displays questions one at a time.
   - User selects True or False.
   - Feedback is shown after pressing "Next".
   - Answers are recorded.

2. **Score Screen:**
   - Shows final score out of total questions.
   - Displays a motivational message based on the score.
   - Includes a “Review” button.

3. **Review Screen:**
   - Displays all questions with the user’s answers, correct answers, and a ✅/❌ status.

---

## ⚙️ Setup
To run this app locally:
1.	Clone the repository:
git clone <your-repository-url>
2.	Open the project in Android Studio.
3.	Build and run the app on an emulator or device.


## 🎨 Design Considerations

- **Simplicity:** Focused on clean typography and straightforward interaction.
- **Feedback Timing:** Feedback (Correct/Wrong) is delayed until "Next" is pressed, reducing pressure.
- **Accessibility:** High contrast, large buttons, and emoji feedback for ease of understanding.
- **Scalability:** Uses parallel arrays for questions, answers, and user responses—easy to expand in the future.
- **Navigation:** Uses explicit `Intent` extras to transfer quiz data between screens.

---

## 🛠️ Tech Stack

- **Language:** Kotlin
- **Framework:** Android SDK
- **UI:** XML Layouts
- **IDE:** Android Studio

---

## 🔗 Git & GitHub Usage

- The project is managed using **Git** for version control and **GitHub** for remote collaboration.
- Git is used to:
  - Track incremental development of features like question navigation, score tracking, and review display.
  - Maintain clean commit history with descriptive messages.
  - Safely test changes in isolated branches if needed.
- GitHub serves as:
  - A backup of the codebase.
  - A platform for future collaboration and feedback via issues and pull requests.
  - A portfolio for showcasing Android development skills.
 
- References
  - https://www.w3schools.com/

### Example Git Workflow

```bash
git add .
git commit -m "created README File and cintaining a comprehensive report detaiking the purpose of the app, the design considerations and the utilisation of github."
git push origin main
