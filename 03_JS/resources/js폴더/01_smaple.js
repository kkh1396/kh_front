// test 라는 이름의 함수 정의

function test() {
    // 실행항 내용 코드
    window.alert("외부파일 부분")
}

window.onload = function() {


// id 속성이 btn2인 요소 선택해서 변수에 저장

let btn2 = document.getElementById('btn2')

// 선택된 요소의 onclick 속성에 실행할 함수 정의 (저장)

btn2.onclick = function( ) {
    console.log('졸려요 정말로요')
}
}