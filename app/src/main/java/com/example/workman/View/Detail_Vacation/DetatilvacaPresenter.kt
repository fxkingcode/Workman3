package com.example.workman.View.Detail_Vacation

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.workman.Model.DAO.VacationModel
import com.example.workman.Model.DTO.EmployeeDto
import com.example.workman.Model.DTO.VacationItem
import com.example.workman.R
import com.example.workman.View.Request_Vacation.ReqvacationContract
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class DetatilvacaPresenter(
    private val context: Context,
    val view: DetailvacaContract.IDetailvacaView
) : DetailvacaContract.IDetailvacaPresenter, DetailvacaContract.Listener {

    private var vacationModel: VacationModel =
        VacationModel()

    override fun callVacationSuccess(vacation: VacationItem) {
        view.setName(vacation.name)
        view.setDate(DateFormat.getDateInstance(DateFormat.LONG).format(vacation.date))

        view.setType(vacation.type)
        if (vacation.type == "반차") {
            vacation.startTime?.let { view.setStartTime(it) }
            vacation.endTime?.let { view.setEndTime(it) }
        } else {
            view.setTimeColor(ContextCompat.getColor(context, R.color.gray2))
        }

        when(vacation.approve) {
            null -> {
                view.setApprove("대기")
                view.setButtonVisible(true)
                view.setApproveColor(ContextCompat.getColor(context, R.color.yellow))
                view.setApproveManager("")
                view.setApproveTime("")
            }
            true -> {
                view.setApprove("승인")
                view.setButtonVisible(false)
                view.setApproveColor(ContextCompat.getColor(context, R.color.green))
                vacation.approveManager?.let { view.setApproveManager(it) }
                vacation.approveDate?.let {
                    view.setApproveTime(
                        DateFormat.getDateInstance(DateFormat.LONG).format(
                            vacation.approveDate
                        ) + SimpleDateFormat("a h:mm").format(vacation.date)
                    )
                }
            }
            false -> {
                view.setApprove("거부")
                view.setButtonVisible(false)
                view.setApproveColor(ContextCompat.getColor(context, R.color.red))
                view.setApproveManagerText("거부 관리자")
                view.setApproveTimeText("거부 날짜")
                vacation.approveManager?.let { view.setApproveManager(it) }
                vacation.approveDate?.let {
                    view.setApproveTime(
                        DateFormat.getDateInstance(DateFormat.LONG).format(
                            vacation.approveDate
                        ) + SimpleDateFormat("a h:mm").format(vacation.date)
                    )
                }
            }
        }

        vacation.reason?.let { view.setReason(it) }
    }

    override fun callVacationSuccessFailure() {
    }

    override fun cancelVacationSuccess() {
        view.toastMessage("취소 성공")
        view.finishActivity()
    }

    override fun cancelVacationSuccessFailure() {
        view.toastMessage("이미 승인된 휴가입니다")
        view.getIdx()?.let { callVacation(it) }
    }

    override fun callVacation(idx: Int) {
        vacationModel.callVacation(idx,this)
    }

    override fun cancelVacation(idx: Int) {
        vacationModel.cancelVacation(idx,this)
    }
}