let crawlingData = [];
const id = document.querySelector('#id');
const loginForm = document.querySelector('#loginForm');
const password = document.querySelector('#password');
const loginButton = document.querySelector('.loginButton');
const poster = document.querySelector('#poster');
const checkSaveId = document.querySelector('#checkSaveId');
const moveRegister = document.querySelector('.moveRegister');
const moveMain = document.querySelector('.moveMain');
// $( document ).ready()와 유사한 코드
document.addEventListener('DOMContentLoaded', () => {
    add();
});


// 데이터 가져오기
 function add() {
    $.ajax({
        url: 'crawling.do',
        type: 'get',
        success: function(data) {
        	crawlingData = setData(data);
            console.log(crawlingData);
            if(crawlingData.length === 0){
            	location.href="moveLogin.do";
            }
            let randomNumber = Math.floor(Math.random() * 7);
            console.log(randomNumber);
            console.log(crawlingData[randomNumber].img);
            poster.setAttribute('src', crawlingData[randomNumber].img);
        },
    });
}

function setData(data) {
    return JSON.parse(data);
}

// 로그인 버튼 클릭시에 동작하는 함수

loginButton.addEventListener('click', () => {
    if (id.value.trim() === '') {
    	toastr.error('아이디를 입력해 주십시오', '경고', {
            timeOut: 3000,
        });
        id.focus();
    } else if (password.value.trim() === '') {
    	toastr.error('비밀번호를 입력해 주십시오', '경고', {
            timeOut: 3000,
        });
        password.focus();
    } else {
        loginForm.submit();
    }
});

// 회원가입 창으로 이동
moveRegister.addEventListener('click', () => {
    location.href = 'moveRegister.do';
});

// 메인 홈페이지로 이동
moveMain.addEventListener('click', () => {
    location.href = 'moveMain.do';
});

// 쿠키 처리 부분
let userId = $.cookie('userId');
if (userId != null) {
    // 지정한 쿠키가 있을 때
    // alert("쿠키 있음");
    // $('#id').val(user_id);
    id.value = userId;
    // $('#chk_save_id').attr('checked', 'checked');
    checkSaveId.setAttribute('checked', 'checked');
}

checkSaveId.addEventListener('click', () => {
    if (checkSaveId.checked === true) {
        if (id.value.trim() === '') {
            alert('id를 입력해 주십시오');
            // $('#chk_save_id').prop('checked', false);
            checkSaveId.checked = false;
        } else {
            // 정상 기입한 경우
            // 쿠키 저장
            $.cookie('userId', id.value.trim(), {
                expires: 7,
                path: './',
            });
        }
    } else {
        // alert("체크 없어짐");
        $.removeCookie('userId', {
            path: './',
        });
    }
});