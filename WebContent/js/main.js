let crawlingData = [];
const movieInformationWrapper = document.querySelector(
    '.movie-infomation-wrapper'
);

const reserveButton = document.querySelector('.reserveButton');
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
//            console.log(data);
            if(crawlingData.length === 0){
            	location.href="moveMain.do";
            }
            setList(data);
            reserveEvent();
        },
    });
}

function setList(data) {
    movieInformationWrapper.innerHTML = JSON.parse(data).reduce(
        (html = '', item, index = 0) => {
            html += getList(item, index);
            console.log(item);
            return html;
        },
        ' '
    );
}

function setData(data) {
    return JSON.parse(data);
}

function reserveEvent() {
    document.querySelectorAll('.reserveButton').forEach((list, index) => {
        console.log(list);
        console.log(index);
        document.querySelector('.movie-informaion');
        moveReserve(list, index);
    });
}

function moveReserve(list, index) {
    list.addEventListener('click', function() {
        console.log(list);
        console.log(index);

        document.querySelector('.movie-informaion').submit();
    });
}

function getList(data, index) {
    return `<form action="moveReserve.do" method="post" class="movie-informaion" id="${index}">
    
    <div class="movie-rank">${data.rank}</div>
    <div class="poster-wrapper"><img src="${data.img}"></div>
    <div>
        <div class="movie-title">${data.movieTitle}</div>
        <div class="movie-rate"><span>예매율</span><span style="margin-left: 10px;">${data.movieRate}</span></div>
        <div class="movie-date">${data.movieOpenDate}</div>
        <div class="like-reserve-wrapper">
            <div><button type="button" class="movie-like"><img class="likeButton"
                        src="./images/heart.png"><span>${data.like}</span></button>
            </div>
            <button type="button" class="reserveButton" id="reserve${index}"><img src="./images/reserve.PNG"></button>
        </div>
    </div>
    <input type="hidden" name="rank" value=${data.rank}>
    <input type="hidden" name="img" value=${data.img}>
    <input type="hidden" name="movieTitle" value=${data.movieTitle}>
    <input type="hidden" name="movieRate" value=${data.movieRate}>
    <input type="hidden" name="movieOpenDate" value=${data.movieOpenDate}>
    <input type="hidden" name="movieRate" value=${data.movieRate}>
    <input type="hidden" name="like" value=${data.like}>
</form>`;
}