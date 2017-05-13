import React from 'react';
import { connect } from 'react-redux';

const CharacterProfile = ({ profile, world }) =>
  <div id='character-profile' className='col-md-6'>
    <h1>UserProfile</h1>
    <div>Name: {this.state.name}</div>
        <div>Eye Color: {this.state.eyeColor}</div>
          <div>DOB:{this.state.birthyear}</div>
        <div>Height: {this.state.height}cm</div>
        <div>gender: {this.state.gender}</div>
          <div>mass: {this.state.mass}cm</div>
        <div>hairColor: {this.state.hairColor}</div>
        <div>skinColor:{this.state.skinColor}</div>

    {}
  </div>;

const mapStateToProps = ({ character: { profile, world } }) => ({
  profile,
  world,
});

export default connect(mapStateToProps)(CharacterProfile);
