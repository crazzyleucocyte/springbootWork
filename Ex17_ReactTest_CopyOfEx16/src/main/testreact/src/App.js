import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';
import { Button, Table } from 'react-bootstrap';

function App() {
  const [hello, setHello] = useState('');
  const [menuList, setMenuList] = useState([]);

  useEffect(()=>{
    axios.get('/api/test')
         .then(result=>{
          setHello(result.data);
         })
  },[]);
  return (
    <div className="App">
      <h3>Hello World!!!</h3>
      <h3>서버에서 들어온 값 : {hello}</h3>
      <br/>
      <hr/>
      <br/>
      <button onClick={()=>{
        axios.get("/api/menuall")
             .then(result =>{
              
             // console.log(result.data)
              setMenuList(result.data)
             })
             .catch(()=>{
              console.log("실패")
             })
      }}>서버에서 메뉴 가져오기</button>
      <Button variant="outline-primary" onClick ={() => {
        axios.post('/api/addmenu', {restaurant:'왓쇼이켄', name : '아카라멘', price:11000, type:'JP', taste:'HOT'})
             .then(result =>{
              console.log(result);
             })
      }}>메뉴 데이터 보내기</Button>

        <div align="center" border="1px">
      <Table striped bordered hover size="sm">
        <thead>
          <tr>
            <th width="10%">번호</th>
            <th width="20%">메뉴명</th>
            <th width="20%">가격</th>
            <th width="20%">음식점명</th>
            <th width="20%">맛</th>
            <th width="10%">종류</th>
          </tr>
        </thead>
        <tbody align="center">
          {console.log("menuList : ", menuList)}
          {menuList.map((v,i)=>{
            return(
              
              <tr>
                <td>{v.id}</td>
                <td>{v.name}</td>
                <td>{v.price}</td>
                <td>{v.restaurant}</td>
                <td>{v.taste}</td>
                <td>{v.type}</td>
              </tr>
            )
          })}
        </tbody>
      </Table>
        </div>
    </div>
  );
}

export default App;
