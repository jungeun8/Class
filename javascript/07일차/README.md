# javascript
// 배열에 저장된 값의 갯수만큼 콜백함수를 실행한다.
// 콜백함수가 실행될 때마다 현재 인덱스 번호와 배열의 값이 콜백함수의 매개변수로 전달된다.
$.each(배열, function(index, item) { 

})

$.each(배열, function() {
   // 콜백함수에서 this를 사용하면 this에는 콜백함수 실행시 전달된 배열의 값이 들어있다.
})

// 선택자로 검색된 엘리먼트의 갯수만큼 콜백함수를 실행한다.
// 콜백함수가 실행될 때마다 검색된 엘리먼트의 인덱스와 엘리먼트가 콜백함수의 매개변수로 전달된다.
$(선택자).each(function(index, el) {

})

$(선택자).each(function() {
   // 콜백함수에서 this를 사용하면 this에는 콜백함수 실행시 전달된 엘리먼트가 들어있다.
})


// 선택자로 검색된 엘리먼트의 갯수만큼 콜백함수가 실행된다.
// 콜백함수가 true를 반환하는 엘리먼트가 최종적으로 선택된다.
// 콜백함수를 실행할 때마다 검색된 검색된 엘리먼의 인덱스와 엘리먼트가 콜백함수의 매개변수로 전달된다.
$(선택자).filter(function(index, el) {
   
})

$(선택자).filter(function() {
   // 콜백함수에서 this를 사용하면 this에는 콜백함수 실행시 전달된 엘리먼트가 들어있다.
})
