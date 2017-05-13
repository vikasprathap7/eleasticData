import React, { Component } from 'react';
import { connect } from 'react-redux';
import ReactDOM from 'react-dom';

class Dashboard extends Component {
  constructor() {
      super();
      this.state = {items: []}
    }
    componentWillMount()
      {
        fetch('http://swapi.co/api/people/?format=json')
        .then(Response => Response.json())
        .then(({results:items}) => {this.setState({items})})
      }
  render()
  {
    return(
      <div>
      <ul>
        {items.map(item =><h4><li>{item.name}</li></h4>)}

        </ul></div>
    );
  }
}

// Which props do we want to inject, given the global state?
function select(state) {
  return {
    data: state
  };
}

// Wrap the component to inject dispatch and state into it
export default connect(select)(Dashboard);
