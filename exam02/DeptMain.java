import java.util.List;
import java.util.Scanner;

import com.dto.DeptDTO;
import com.exception.DuplicatedDeptnoException;
import com.service.DeptService;
import com.service.DeptServiceimpl;
import com.service.DeptServiceimpl;

public class DeptMain {

	public static void main(String[] args) {

		//화면처리 추가
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("1. 전체목록");
			System.out.println("2. 저장하기");
			System.out.println("3. 수정하기");
			System.out.println("0. 종료");
			System.out.println("--------------------");
			String num = scan.nextLine();
			if("1".equals(num)) {
				// 서비스 연동
				DeptService service = new DeptServiceimpl(); //다형성
				List<DeptDTO> list = service.findAll();
				System.out.println("부서번호\t 부서명 \t 부서위치");
				System.out.println("------------------------");
				for (DeptDTO dto : list) {
					System.out.println(dto); // dto.toString()
				}
			}else if("2".equals(num)) {
				System.out.println("부서번호를 입력하시오");
				String deptno = scan.next();
				System.out.println("부서명를 입력하시오");
				String dname = scan.next();
				System.out.println("부서위치를 입력하시오");
				String loc = scan.next();
				// 입력받은 3가지 값을 DTO에 저장해서 서비스 거쳐서 DAO까지 전달한다.
				DeptDTO dto = 
						new DeptDTO(Integer.parseInt(deptno), dname, loc);
				//서비스 연동
				DeptService service =
						new DeptServiceimpl();
				int n=0;
				try {
					n = service.insert(dto);
				} catch (DuplicatedDeptnoException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(n+" 개가 저장되었습니다");
				
			}else if("3".equals(num)) {
				System.out.println("수정할 부서번호를 입력하시오");
				String deptno = scan.next();
				System.out.println("수정할 부서명를 입력하시오");
				String dname = scan.next();
				System.out.println("수정할 부서위치를 입력하시오");
				String loc = scan.next();
				DeptDTO dto = 
						new DeptDTO(Integer.parseInt(deptno), dname, loc);
				
				//service 연동
				DeptService service = new DeptServiceimpl();
				int n = service.update(dto);
				System.out.println(n+" 개가 수정되었습니다");
				
			}else if("0".equals(num)) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}
			
			
		}//end while
		
	}//end main
}//end class