import profilepicture from "../assets/image/profilePicture.jpg";

function Card() {
  return (
    <div className="card">
      <img
        className="card-image"
        src={profilepicture}
        alt="profile picture"
      ></img>
      <h2 className="card-title">Jon Snow</h2>
      <p className="card-text">I stick my quene</p>
    </div>
  );
}

export default Card;
