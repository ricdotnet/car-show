const imageModal = document.getElementById('image-modal');
const cross = 'https://upload.wikimedia.org/wikipedia/commons/thumb/8/8f/Flat_cross_icon.svg/1200px-Flat_cross_icon.svg.png';

function showImageModal(imageUrl, brandName, modelName) {
    imageModal.innerHTML = `
        <div class="image-box rounded-sm">
            <img src="${imageUrl}" alt="${brandName} ${modelName}" class="rounded-sm" width="100%"/> <br/>
            <img src="${cross}" alt="close" onclick="hideImageModal()" width="30px" class="cursor-pointer"/>
            <span class="sub-title">${brandName} ${modelName}</span>
        </div>
    `
    imageModal.classList.remove('hidden')
}
function hideImageModal() {
    imageModal.innerHTML = "";
    imageModal.classList.add('hidden')
}

window.addEventListener('keydown', event => {
    if(event.key === 'Escape') {
        hideImageModal();
    }
})