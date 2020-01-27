# Toy Porject

## Theater

### 계획

#### 모델

1. 영화관 모델 생성

    1. Movie - 영화
    
    1. Screen - 상영관
    
    1. Seat - 좌석

1. 영화 예매용 모델 생성

    1. Reservation - 예약

1. 고객 모델 생성

    1. Customer - 고객

1. 할인 & 정책 생성

    1. Policy - 정책

    1. Discount - 할인

#### API

##### 사용자

1. 영화정보

    1. 조회
  
        1. 영화 정보 리스트 조회

        1. 영화 상세 정보 조회

    1. 상영 정보 조회

1. 저장
  
    1. 영화 정보 예약
      
    1. 트랜잭션처리
      
        1. ISOLATION = REPEATABLE_READ
        
        1. PROPAGATION = REQUEST_NEW
