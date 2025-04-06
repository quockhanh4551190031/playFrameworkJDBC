$(document).ready(function() {
    // Load posts when page loads
    loadPosts();
    
    // Handle post form submission
    $('#post-form').submit(function(e) {
        e.preventDefault();
        
        const title = $('#title').val();
        const body = $('#body').val();
        const csrfToken = $('input[name="csrfToken"]').val();
        
        $.ajax({
            url: '/posts',
            type: 'POST',
            contentType: 'application/json',
            headers: {
                'Csrf-Token': csrfToken
            },
            data: JSON.stringify({
                title: title,
                body: body
            }),
            success: function(response) {
                // Clear form
                $('#title').val('');
                $('#body').val('');
                
                // Reload posts
                loadPosts();
            },
            error: function(xhr) {
                alert('Error creating post: ' + xhr.responseText);
            }
        });
    });
    
    // Function to load posts
    function loadPosts() {
        $.ajax({
            url: '/posts',
            type: 'GET',
            success: function(posts) {
                const container = $('#posts-container');
                container.empty();
                
                if (posts.length === 0) {
                    container.append('<p>No posts yet.</p>');
                    return;
                }
                
                posts.forEach(function(post) {
                    const postDate = new Date(post.createdAt).toLocaleString();
                    const isCurrentUser = post.userId === parseInt($('meta[name="userId"]').attr('content'));
                    
                    let deleteButton = '';
                    if (isCurrentUser) {
                        deleteButton = `
                            <form class="delete-post-form" data-post-id="${post.id}">
                                <button type="submit" class="btn btn-sm btn-danger">Delete</button>
                            </form>
                        `;
                    }
                    
                    const postHtml = `
                        <div class="card mb-3">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <div>
                                    <h5 class="mb-0">${post.title}</h5>
                                    <small>Posted by ${post.username} on ${postDate}</small>
                                </div>
                                ${deleteButton}
                            </div>
                            <div class="card-body">
                                <p class="card-text">${post.body}</p>
                            </div>
                        </div>
                    `;
                    
                    container.append(postHtml);
                });
                
                // Add event listeners for delete buttons
                $('.delete-post-form').submit(function(e) {
                    e.preventDefault();
                    const postId = $(this).data('post-id');
                    deletePost(postId);
                });
            },
            error: function(xhr) {
                $('#posts-container').html('<p>Error loading posts.</p>');
            }
        });
    }
    
    // Function to delete a post
    function deletePost(postId) {
        if (confirm('Are you sure you want to delete this post?')) {
            const csrfToken = $('input[name="csrfToken"]').val();
            
            $.ajax({
                url: '/posts/' + postId,
                type: 'DELETE',
                headers: {
                    'Csrf-Token': csrfToken
                },
                success: function() {
                    loadPosts();
                },
                error: function(xhr) {
                    alert('Error deleting post: ' + xhr.responseText);
                }
            });
        }
    }
});