document.addEventListener('DOMContentLoaded', function() {
    // Get all More Information buttons and attach click event listeners
    const moreInfoButtons = document.querySelectorAll('.more-info-btn');

    moreInfoButtons.forEach(button => {
        button.addEventListener('click', async () => {
            // Find the parent search result div
            const searchResult = button.closest('.search-result');

            // Fetch additional information from TMDB API
            const movieId = searchResult.dataset.movieId;
            const apiUrl = `https://api.themoviedb.org/3/movie/${movieId}?api_key=2e778d5f31e240b493d778371b6bbcb8`;
            const response = await fetch(apiUrl);
            const movieDetails = await response.json();

            // Populate additional information
            searchResult.querySelector('.popularity').textContent = `${movieDetails.popularity}`;
            searchResult.querySelector('.release-date').textContent = `${movieDetails.release_date}`;
            searchResult.querySelector('.vote-average').textContent = `${movieDetails.vote_average}`;
            searchResult.querySelector('.vote-count').textContent = `${movieDetails.vote_count}`;

            // Mark as fetched
            searchResult.dataset.fetched = true;

            // Toggle visibility of additional information
            const additionalInfo = searchResult.querySelector('.additional-info');
            additionalInfo.style.display = additionalInfo.style.display === 'none' || additionalInfo.style.display === '' ? 'block' : 'none';

            // Change button text and functionality
            button.textContent = additionalInfo.style.display === 'none' ? 'Show More' : 'Show Less';

        });
    });
});