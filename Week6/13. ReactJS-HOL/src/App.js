const books = [
  { id: 1, title: 'React Basics' },
  { id: 2, title: 'JavaScript Essentials' }
];

const blogs = [
  { id: 1, title: 'State and Props' },
  { id: 2, title: 'Functional Components' }
];

const courses = [
  { id: 1, title: 'Full Stack React' },
  { id: 2, title: 'UI Design Patterns' }
];

function BookDetails() {
  if (books.length === 0) {
    return <p>No books available.</p>;
  }

  return (
    <div>
      <h2>Book Details</h2>
      {books.map((book) => (
        <div key={book.id}>{book.title}</div>
      ))}
    </div>
  );
}

function BlogDetails() {
  return blogs.length > 0 ? (
    <div>
      <h2>Blog Details</h2>
      {blogs.map((blog) => (
        <div key={blog.id}>{blog.title}</div>
      ))}
    </div>
  ) : (
    <p>No blogs available.</p>
  );
}

function CourseDetails() {
  const courseList = courses.map((course) => <div key={course.id}>{course.title}</div>);

  return (
    <div>
      <h2>Course Details</h2>
      {courses.length > 0 && courseList}
    </div>
  );
}

function App() {
  const showBooks = true;
  const showBlogs = true;
  const showCourses = true;

  return (
    <div>
      {showBooks && <BookDetails />}
      {showBlogs ? <BlogDetails /> : <p>Blogs are hidden.</p>}
      {showCourses ? (
        <CourseDetails />
      ) : (
        <p>Courses are hidden.</p>
      )}
    </div>
  );
}

export default App;
