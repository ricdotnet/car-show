'use strict'

const modalBg = document.getElementById('modal-bg');
const modal = document.getElementById('modal');

function modalShow() {
    modalBg.classList.remove('hidden')
}

window.addEventListener('keydown', event => {
    if(event.key === 'Escape') {
        modalBg.classList.add('hidden')
    }
})