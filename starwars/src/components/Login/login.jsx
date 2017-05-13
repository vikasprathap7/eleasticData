var React = require('react');
var ReactDOM = require('react-dom');
var HomePageItem = require('./components/Nav/HomePageItem.jsx');
var React = require('react');
var Link = require('react-router').Link;
var App = require('./components/App.jsx');

var login = React.createClass({

  render: function() {

    return (
    <form>
  <label>
    Name:
    <input type="text" name="name" />
  </label>
  <label>
    Password:
    <input type="password" name="name" />
  </label>
  <input type="submit" value="Submit" />
</form>

    );
  }
});

module.exports = login;
