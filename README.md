## assignment_AP
#Project 2 - backpack

Ever since the arrival of Google Classroom (GC), it has been the go-to Learning Management
System (LMS) for IIITD. LMS is the backbone of how teaching is delivered at IIITD. For quite
some time now, it has been observed that IIITD should have its very own LMS, and the institute
administration has named the project, "BACKPACK". You have been contacted by BYLD, the
developer group at IIITD to give your inputs on this project. They want you to use the
knowledge of OOP that you have gathered from Assignment-1 along with interfaces, and
polymorphism to design a robust system that can support multiple roles. The system will be
used by Instructors (a single course can have multiple instructors like GC) and Students.
For now, you are supposed to design a single course page that has users for the roles
mentioned above and show BYLD a working command line simulation.
INSTRUCTOR:
          1. An instructor can upload and view lecture materials. Lecture material can be of two
          types:
          a. Lecture Videos: A filename with extension .mp4
          b. Lecture Slides: An array of strings representing the content of the slides
          2. An instructor can upload and grade assessments. The assessments can be of two
          types:
          a. Assignments: Problem Statement describing the assignment
          b. Quizzes: A single question requiring a one-word answer
          3. Also while uploading an assignment an instructor will specify the maximum marks
          possible for that assignment, which will be used when an instructor grades the
          submissions. For a quiz, the maximum marks are by default 1.
          4. An instructor will also be required to close an assessment after which no submissions
          will be accepted.
STUDENT:
          1. A student can view the uploaded lecture material
          2. A student should be able to view assessments and upload submissions which will be
          graded by the instructor. The format of submissions will be as follows:
          a. Assignments: A filename with extension .zip (eg: sample_submission.zip)
          b. Quiz: A one-word solution to the question
          3. Students can check if their submission has been graded, and marks received for the
          same.

COMMON FUNCTIONS:
    Discussions in forums are an important part of any active learning environment. To facilitate
    this everyone should be allowed to add comments in a course discussion forum. Every member
    of the course both instructors and students should be able to add comments and view other
    comments. While viewing, comments should be displayed along with the name of the member
    who added them and the timestamp of the comment. Unlike google classroom where we are
    allowed to add comments to assessments and lecture materials. BYLD wants you to create a
    simple discussion forum for the time being where members can add comments and view them.
    For simulating this assignment you will be required to create a dummy course with some
    dummy accounts for both instructor and students. And at any point in time, you should be able
    to log out of a user and log in as another user. When logged in as an instructor we should be
    able to use the system from the perspective of an instructor. When we log in as a student we
    should be able to perform functions required by a student.
    Please thoroughly go through the sample run below to understand the program flow. Please
    refrain from asking questions related to your approaches from the TAs and hope you are able
    to help BYLD with the following task.
    Some repetitive print statements:
    
INSTRUCTOR MENU
  1. Add class material
  2. Add assessments
  3. View lecture materials
  4. View assessments
  5. Grade assessments
  6. Close assessment
  7. View comments
  8. Add comments
  9. Logout

STUDENT MENU
  1. View lecture materials
  2. View assessments
  3. Submit assessment
  4. View grades
  5. View comments
  6. Add comments
  7. Logout

#Project 3 - Snakes and Ladder
1. **Player**
   This is a single player game with a really simple objective: how many game points the player
   obtained when he completed the game. The player has a name and s/he must remember his
   position on the game floor after every move.
2. **Game**
   As shown in the picture, the game would have 14 floors and it counts the total points collected
   during the game play. Negative points are also allowed in the game. There are different types of
   floors: a) empty floor, b) snake floor, and c) ladder floor. There are two types of snake floor that
   you can ever encounter: a) normal and b) king cobra. Likewise, there are two types of ladders
   that you can ever encounter: a) normal, and b) elevator. The location of each snake floor, ladder
   floor, and empty floor is fixed as shown in the picture. Each floor must remember its location in
   the game.
   Whenever a player moves to any floor, s/he has to jump on the floor to know the type of floor:
   1. Empty floor rewards the player with one point and displays the message that player has
   reached an empty floor.
   2. Normal snake floor would deduct two points from total and would display the message
   that player has reached normal snake floor. After this it will move the player’s position to
   the first floor as shown in the picture.
   3. King cobra snake would deduct four points from total and would display the message
   that player has reached king cobra. After this it will move the player’s position to the third
   floor as shown in the picture.
   4. Ladder floor rewards the player with two points and displays the message that the player
   has reached a ladder floor. After this it will move the player’s position to the twelfth floor
   as shown in the picture.
   5. Elevator floor rewards the player with four points and displays the message that the
   player has reached the elevator floor. After this it will move the player’s position to the
   tenth floor as shown in the picture.
3. **Dice**
   This game has a special dice that has only two faces, 1 and 2. When a die is thrown, it returns
   a randomly chosen face value.
4. **Cheat Codes** It also incorporates a secret cheat code available to the runner.