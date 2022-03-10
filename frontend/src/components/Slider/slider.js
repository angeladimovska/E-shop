import React, {useState} from "react";
import styled from "styled-components";
import {ArrowBackIos, ArrowForwardIos} from "@material-ui/icons"

const Container=styled.div`
  width: 100%;
  height: 100vh;
  display:flex;
  position: relative;
  overflow: hidden;
  
`;
const Arrow=styled.div`
  width: 60px;
  height: 60px;
  border: 0.5px solid white;
  //za da e krugce borderot a ne kocka
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  position: absolute;
  top: 0;
  bottom: 0;
  left: ${props=>props.direction === "left" && "10px"};
  right: ${props=>props.direction === "right" && "10px"};
  margin: auto;
  cursor: pointer;
  z-index: 2;
`;

//sea so slikite
const Wrapper=styled.div`
    height: 100%;
    display: flex;
  //transform: translateX(0vw);
`;

const Slide=styled.div`
    display: flex;
    align-items: center;
    width: 100vw;
    height: 100vh;
`;

const ImgContainer=styled.div`
  height: 100%; 
  flex: 1; 
`;

const InfoContainer=styled.div`
  position: absolute;
  right: 13%;
  bottom: 40%;
`;
const Image=styled.img`
  width: 100vw;
  height: 100vh;
`;

const Title=styled.h1`
  font-size: 60px;
`;
const Desc=styled.p`
    margin: 20px 0 ;
    font-weight: 500;
    font-size: 20px;
    letter-spacing: 2px;
`;
const Button=styled.button`
  padding: 6px;
  background: transparent;
  cursor: pointer;
`;

const Slider = () => {

    const[slideIndex, setSlideIndex]=useState(0)

    const handleClick = (direction)=>{

    };

    return (
        <Container>
            <Arrow direction="left" onClick={() => handleClick("left")}>
                <ArrowBackIos/>
            </Arrow>
            <Wrapper>
                <Slide>
                <ImgContainer>
                    <Image src="https://abc-7.com/wp-content/uploads/2021/06/makeup-products.jpg"/>
                    <InfoContainer>
                        <Title>FREE ROUTINE</Title>
                        <Desc>Apply and get an answer in 24 hours</Desc>
                        <Button>Apply now</Button>
                    </InfoContainer>
                </ImgContainer>
                </Slide>

                <Slide>
                    <ImgContainer>
                        <Image src="https://abc-7.com/wp-content/uploads/2021/06/makeup-products.jpg"/>
                        <InfoContainer>
                            <Title>FREE ROUTINE</Title>
                            <Desc>Apply and get an answer in 24 hours</Desc>
                            <Button>Apply now</Button>
                        </InfoContainer>
                    </ImgContainer>
                </Slide>
            </Wrapper>
            <Arrow direction="right" onClick={() => handleClick("right")}>
                <ArrowForwardIos/>
            </Arrow>
        </Container>
    );
}
export default Slider;