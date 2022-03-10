import React from "react";
import styled from "styled-components";
import {Search, ShoppingCartOutlined} from "@material-ui/icons";

const Container= styled.div`
       height: 60px;
`
//logo search input i login register links i kosnicka
const Wrapper= styled.div`
    padding: 10px 20px;
    display: flex;
    align-items: center;
    justify-content: space-between;
`;

const Left= styled.div`
  flex:1;
  display: flex;
  align-items: center;
`;

const Logo=styled.h1`
  font-weight: bold;
`;

const SearchContainer=styled.div`
    border: 0.5px solid lightgray;
    display: flex;
    align-items: center;
    margin-left: 25px;
    padding: 5px;
`;

const Input=styled.input`
   border: none; 
`;
const Center= styled.div`
  flex:1;
  text-align: center;
`;

const Right= styled.div`
  flex:1;
  display: flex;
  align-items: center;
  justify-content: flex-end;
`;

const MenuItem=styled.div`
  font-size: 14px;
  cursor: pointer; 
  margin-left: 25px;
`;

const Navbar = () => {
    return (
        <Container>
            <Wrapper>
                <Left>
                    <SearchContainer>
                        <Input/>
                        <Search style={{color: "gray", fontSize: 16}}/>
                    </SearchContainer>
                </Left>
                <Center>
                    <Logo>PAGENAME</Logo>
                </Center>
                <Right>
                    <MenuItem>REGISTER</MenuItem>
                    <MenuItem>SIGN IN</MenuItem>
                    <MenuItem>
                        <ShoppingCartOutlined/>
                    </MenuItem>
                </Right>
            </Wrapper>
        </Container>
    );
}
export default Navbar;