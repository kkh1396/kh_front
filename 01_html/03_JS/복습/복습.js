        // ----------- 요소 선택 ------------------------------
        
        let color_box = document.getElementById("color-box"); // id 속성: color-box
        
        let input_color = document.getElementById("color-input"); // id 속성: color-input

        let applyButton = document.getElementById("apply-button");   // id 속성: apply-button
        
        let message = document.getElementById('message');  // id 속성: message

        // 버튼 클릭 이벤트 핸들러
        applyButton.onclick = function () {
            
            // 선택된 색상 값 조회(가져오기) -> input요소의 값 조회 : value 속성
            let color = input_color.value;

            // #color-box 요소의 스타일 중 배경색 변경
                color_box.style.backgroundColor = color ; 

            // #message 요소에 변경된 배경색 정보로 출력
            message.innerHTML = "현재 배경색은 " + color + "입니다.";
        };
