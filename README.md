AssignmentProject

GitHub
- https://github.com/blackhtr/AssignmentProject

기술 스택
- Kotlin: 프로젝트의 모든 코드에 사용된 언어
- Jetpack Compose: 선언형 UI 프레임워크
- Hilt: 의존성 주입(DI)을 통한 컴포넌트 관리
- Retrofit: REST API 통신 라이브러리
- Kotlin Coroutines: 비동기 처리
- MVVM 아키텍처: Model-View-ViewModel 구조로 구조적이고 테스트 가능한 코드 제공
- 멀티모듈 구조: 기능별로 모듈을 분리하여 유지보수 용이

프로젝트 구조
- app                   # 애플리케이션의 메인 엔트리 포인트
- core                    
  - data                # 데이터 모델 및 API 서비스 정의
  - domain              # 비즈니스 로직 및 유즈케이스
- feature 
  - wiki                # 검색, 상세 화면 및 관련 로직

