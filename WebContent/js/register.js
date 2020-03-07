let crawlingData = [];
const idCheckButton = document.querySelector('.idCheckButton');
const registerButton = document.querySelector('.registerButton');
const id = document.querySelector('#id');
const registerForm = document.querySelector('#registerForm');
const password = document.querySelector('#password');
const passwordRepeat = document.querySelector('#passwordRepeat');
const poster = document.querySelector('#poster');
let idFlag = false;

document.addEventListener('DOMContentLoaded', () => {
    idCheckButton.addEventListener('click', function() {
        console.log(document.querySelector('#id').value);
        idCheck();
    });
    add();

    registerButton.addEventListener('click', () => {
        registerForm.submit();
    });
});

function idCheck() {
    $.ajax({
        url: 'idCheck.do',
        type: 'get',
        data: { id: document.querySelector('#id').value },
        success: function(data) {
            console.log(data);
            idCheckMessage(data);
        },
    });
}

function add() {
    $.ajax({
        url: 'crawling.do',
        type: 'get',
        success: function(data) {
            crawlingData = setData(data);
            console.log(crawlingData);
            if(crawlingData.length === 0){
            	location.href="moveRegister.do";
            }
            let randomNumber = Math.floor(Math.random() * 7);
            console.log(randomNumber);
            poster.setAttribute('src', crawlingData[randomNumber].img);
        },
    });
}

function setData(data) {
    data = JSON.parse(data);

    return data;
}

function idCheckMessage(data) {
    toastr.options = {
        positionClass: 'toast-top-full-width',
        progressBar: true,
        timeOut: 1000,
    };
    if (id.value.length < 3) {
        toastr.error('최소 4글자 이상의 아이디를 입력해 주세요', '아이디 확인', {
            timeOut: 3000,
        });
        return;
    }

    if (data === 'false') {
        toastr.success('사용할수 있는 아이디입니다', '아이디 확인', {
            timeOut: 3000,
        });
        return idFlag = true;
        //registerButton.removeAttribute('disabled');
    } else {
        toastr.error('이미 존재하는 아이디입니다', '아이디 확인', {
            timeOut: 3000,
        });
        return idFlag = false;
        //registerButton.setAttribute('disabled', 'true');
    }
}

// register.jsp의 onChange함수에 넣었다.
function passwordValidate() {
    if (password.value == passwordRepeat.value) {
        toastr.options = {
            positionClass: 'toast-top-right',
            progressBar: true,
            timeOut: 1000,
        };
        toastr.success('비밀번호가 일치합니다', '비밀번호 확인', {
            timeOut: 3000,
        });
//        registerButton.removeAttribute('disabled');
//        registerButton.classList.toggle('clickedButton', false);

        if(idFlag === true){
        	registerButton.removeAttribute('disabled');
            registerButton.classList.toggle('clickedButton', false);
        }
        return true;
    } else {
        toastr.options = {
            positionClass: 'toast-top-right',
            progressBar: true,
            timeOut: 1000,
        };
        registerButton.classList.toggle('clickedButton', true);
        toastr.error('비밀번호가 일치하지 않습니다', '비밀번호 확인', {
            timeOut: 3000,
        });
        return false;
    }
}


