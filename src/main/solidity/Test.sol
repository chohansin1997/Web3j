// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

contract Test {
    uint256 public a = 3;
    uint public sumNum = 0;
    string public hello = "helloWorld!!!";

    //4. parameter 와 return 값이 있는 function
    function plus(uint256 start, uint256 end) public {
        sumNum = start + end;
    }

    function getSumNum() public view returns (uint) {
        return sumNum;
    }
    // plus 에서 값을 연산 한뒤에 getSumNum 을해서 가져오면 더하기가 잘되어있음
    function plus2(uint256 start, uint256 end) public returns (uint) {
        return sumNum = start + end;
    }
    // plus2를 연산 할경우 output 값이 없음 하지만 plus2 를 연산하고 getSumNum()으로 값을 빼면 값이 연산된 값으로 잘나옴
    //왜 인지는 모르겠지만 연산과 return이 동시에 안되는듯.

    //왜 view가 붙어야지 값이 나오는지 ? view는 수정여부를정하는게 아닌가?
    function helloWorld() public view returns (string memory) {
        return hello;
    }

    function helloWorldNoView() public returns (string memory) {
        return hello;
    }

}

