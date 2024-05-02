# Auto Trading System

자동 매매 프로그램 TDD 기반 개발.

## 개발 기능

- App 제공
  - 증권사 선택 기능 : selectStockBroker(broker)
  - 적시 매수 기능 : buyNiceTiming(stockCode, amount)
  - 적시 매도 기능 : sellNiceTiming(stockCode, amount)

- Driver 제공
  - 로그인 기능 : login(id, pass)
  - 매수 기능 : buy(stockCode, amount, price)
  - 매도 기능 : sell(stockCode, amount, price)
  - 현재가 확인 기능 : getPrice(stockCode)

## 요구사항 상세

- 종목 수: 2개
- buyNiceTiming: 200ms 기준 3번 모두 상승이고, 4번째에서도 상승이면 매수
- sellNiceTiming: 200ms 기준 3번 모두 하락이고, 4번째에서도 하락이면 매수