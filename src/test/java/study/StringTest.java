package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    // 삼일째 삽질 중이다. 이 쉬운걸 삽질한다고 생각할 수도 있겠지만 처음 써보고 누구도 알려주지 않는다.
    // 1. 테스트를 진행해 봐야하겠지만 알아낸 것은 main에 클래스 파일이 존재해야하며 main에 구현된 클래스를 가지고 테스트folder에 테스트만 따로 구현해야한다.
    // 2. 테스트 파일을 만들어 테스트를 하려면 open module setting에서 test파일을 지정해 주어야 한다.
    // 3. test코드를 작성하기 위해서는 junit open API를 가지고 있어야하며 적용시키는 방법을 공부해야한다.
    @Test
    void replace() {
        //given
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");

        //when

        //then
    }
    @Test
    void split(){
        String[] arr = "1,2".split(",");

        assertThat(Arrays.toString(arr)).isEqualTo("[1, 2]");
    }

    @Test
    void split1(){
        String[] arr = "1".split(",");

        assertThat(Arrays.toString(arr)).isEqualTo("[1]");
    }

    @Test
    void substring(){
       String text = "(1,2)";

       text = text.substring(1,4);

        assertThat(text).isEqualTo("1,2");
    }

    @Test
    @DisplayName("캐릭터엣 메서드 테스트")
    void changWord() {
        String ch = "abc";
        int index = 5;
        // so what is the assertThatThrownBy(java API : assertJ)? is java library. and better than assertEquals
        // assertThat("what kind of return value you want").(method from assertj)
        // 그리고 assertion을 사용할 때는 설명이 필요한 부분들은 as() method를 이용하면된다. 구성은 as("설명",대상(assertThat(이거))).assertion(assertJ가 제공하는 메서드자리이다.)
        // 예상되는 예외를 지정해 놓고 일부로 예외를 발생시켜서 해당 예외가 맞는지 체크하는 메서드
        // hasStackTraceContaining 같은 경우에는 올바른 범위를 알릴 수 있게 Trace를 로그에 찍을 때 해당 메세지와 함께 찍을 수 있게 설정하는 것
        assertThatThrownBy(()->{
            ch.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasStackTraceContaining("Index : %d, Size: %d",ch.length()-1 ,ch.length()-1);
    //설명추가


    }

    @Tag("TestObject")
    @DisplayName("테스트 대상")
    public class abc{

        private String ch = "abc";

    }
}
