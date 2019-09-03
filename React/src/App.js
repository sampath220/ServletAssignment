import React from 'react';
import {BrowserRouter as Router,Route} from 'react-router-dom' 
import './App.css';
import Header from './Header';
import AddForm from './AddForm';
import Display from './Search';
import Sorting from './Sorting'

function App() {
  return (
    <Router>
      <Header/>
      <Route exact path='/addform' component={AddForm} ></Route>
      <Route exact path='/display' component={Display}></Route>
      <Route exact path='/sorting' component={Sorting}></Route>
    </Router>
  );
}

export default App;
