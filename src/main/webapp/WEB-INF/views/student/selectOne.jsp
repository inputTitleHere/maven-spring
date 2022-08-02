<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis 실습</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
<style>
div#student-container {
	text-align: center;
}

table.tbl-student {
	margin: 10px auto;
	border: 1px solid;
	border-collapse: collapse;
}

table.tbl-student th, table.tbl-student td {
	border: 1px solid;
	padding: 5px;
	line-height: 2em; /*input태그로 인해 cell이 높이가 길어져 border 두줄현상방지 */
}

table.tbl-student th {
	text-align: right;
}

table.tbl-student td {
	text-align: left;
}

table.tbl-student tr:last-of-type td:first-child {
	text-align: center;
}
</style>
</head>
<body>
	<div id="student-container">
		<h2>학생정보 검색</h2>
		<p>
			등록된 총 학생수는 <span id="totalCount">${totalCount }</span>명입니다.
		</p>
		<form name="studentSearchFrm">
			<table class="tbl-student">
				<tr>
					<th>학생번호</th>
					<td><input type="number" name="no" value="" required /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="검색" /></td>
				</tr>
			</table>
		</form>

		<hr />

		<h2>학생 정보 수정</h2>
		<form name="studentUpdateFrm">
			<table class="tbl-student">
				<tr>
					<th>학생번호</th>
					<td><input type="number" name="no" required readonly /></td>
				</tr>
				<tr>
					<th>학생이름</th>
					<td><input type="text" name="name" required /></td>
				</tr>
				<tr>
					<th>학생전화번호</th>
					<td><input type="tel" name="tel" required /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="수정"
						onclick="updateStudent();" /> <input type="button" value="삭제"
						onclick="deleteStudent();" /></td>
				</tr>
			</table>
		</form>
	</div>


	<script>
	const updateStudent=()=>{
		const e = document.studentUpdateFrm;
		const no = e.no.value;
		const name = e.name.value;
		const tel = e.tel.value;
		
		$.ajax({
			url:'${pageContext.request.contextPath}/student/updateStudent.do',
			data:{
				"no":no,
				"name":name,
				"tel":tel
			},
			method:"GET",
			success(response){
				console.log(response);
				alert("회원정보 수정되었습니다!");
			},
			error:console.log
		})
	}
	
	const deleteStudent=()=>{
		const frm = document.studentUpdateFrm;
		const no=frm.no.value;
		$.ajax({
			url:'${pageContext.request.contextPath}/student/deleteStudent.do',
			data:{"no":no},
			method:"GET",
			success(response){
				alert("회원을 삭제했습니다.");
				location.href='${pageContext.request.contextPath}/student/selectOne.do';
			},
			error:console.log
			
		});
		
	}
	
	
	document.studentSearchFrm.addEventListener('submit',(e)=>{
		e.preventDefault();
		const no=e.target.no.value;
		const frm = document.studentUpdateFrm;
		$.ajax({
			url:'${pageContext.request.contextPath}/student/student.do',
			data:{no},
			success(student){
				console.log(student);
				if(student){										
					const {no, name, tel}=student;
					frm.no.value=no;
					frm.name.value=name;
					frm.tel.value=tel;
				}else{
					alert('조회한 학생이 존재하지 않습니다.');
					frm.reset();
				}
			},
			error:console.log
		})
	})
	
	</script>

</body>
</html>
