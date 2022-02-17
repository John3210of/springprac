<h1> API </h1>


https://www.notion.so/Spring-myblog-API-a00cb0f033f045768ad9a287921efa92



<h2> 개선해야 할 점 </h2>

양방향 매핑을 통해 게시글과 댓글의 관계를 선언해야하는데, 하지 못해서 postid를 댓글 입력시에 같이 입력해주는 식으로 하였다.

때문에, postid에 아무 값이나 넣었을때, 그 값에 해당하는 게시글의 pk가 없을경우에 예외처리를 해주어야 했다.

또한 게시글이나 댓글의 제목이나 이름으로 들어갈 부분에 대해서도 예외처리를 해주어야 했다. 

현재 조건범위를 잘못 정해서 모든 에러에 대해 같은 메시지가 나오는데, 이 부분을 세분화 하고 위에 내용에 대한 예외처리 로직도 넣어줘야 한다. 









![image](https://user-images.githubusercontent.com/94155128/154450228-9387ffde-fc1c-4319-b9d2-b7eae63f7e9e.png)
![image](https://user-images.githubusercontent.com/94155128/154450340-6acff5da-72d2-4d76-9193-d9524365324d.png)
