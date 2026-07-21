import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: []
    };
  }

  loadPosts = async () => {
    try {
      const response = await fetch('https://jsonplaceholder.typicode.com/posts');
      const data = await response.json();
      const posts = data.map((item) => new Post(item.id, item.title, item.body));
      this.setState({ posts });
    } catch (error) {
      window.alert('Unable to load posts.');
    }
  };

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error) {
    window.alert('An error occurred while rendering posts.');
    console.error(error);
  }

  render() {
    return (
      <div>
        {this.state.posts.map((post) => (
          <div key={post.id}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
