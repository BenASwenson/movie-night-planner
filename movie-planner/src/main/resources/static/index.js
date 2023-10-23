// Get all More Information buttons and attach click event listeners
const moreInfoButtons = document.querySelectorAll('.more-info-btn');

moreInfoButtons.forEach(button => {
    button.addEventListener('click', () => {
        // Find the parent search result div
        const searchResult = button.closest('.search-result');

        // Toggle visibility of additional information
        const additionalInfo = searchResult.querySelector('.additional-info');
        additionalInfo.style.display = additionalInfo.style.display === 'none' ? 'block' : 'none';

        // Hide the More Information button after it's clicked
        button.style.display = 'none';

        // Fetch additional information
        const popularity = "hugely popular" /* fetch popularity */;
        const releaseDate = "1999" /* fetch release date */;
        const voteAverage = "8" /* fetch vote average */;
        const voteCount = "1111"/* fetch vote count */;

        // Populate additional information
        searchResult.querySelector('.popularity').textContent = popularity;
        searchResult.querySelector('.release-date').textContent = releaseDate;
        searchResult.querySelector('.vote-average').textContent = voteAverage;
        searchResult.querySelector('.vote-count').textContent = voteCount;
    });
});