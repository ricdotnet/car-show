'use strict'

// const carsButton = document.getElementById('car-button');
const subNav = document.getElementById('sub-nav');

window.addEventListener('click', ev => {
    if(ev.target.id === 'car-button') {
        subNav.classList.contains('hidden') ? subNav.classList.remove('hidden') : subNav.classList.add('hidden');
    } else if(ev.target.id !== 'sub-nav' && !subNav.classList.contains('hidden')) {
        subNav.classList.add('hidden')
    }
})

window.addEventListener('keydown', ev => {
    if(ev.key === 'Escape') {
        subNav.classList.add('hidden')
    }
})