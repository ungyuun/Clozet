import { Modal } from "antd";

const StockModal = ({stock,onToggleModal}) => {
    return(
        <Modal title="재고 부족 알림" visible={true} onOk={onToggleModal} onCancel={onToggleModal}>
            {stock.map((stocks,idx)=>(
                <div>
                    <div>{stocks.title} 제품의 {stocks.size} 사이즈는 재고부족입니다</div>
                    <div>남은재고 : {stocks.amount}</div>
                </div>
            ))}
        </Modal>
    )
}

export default StockModal;