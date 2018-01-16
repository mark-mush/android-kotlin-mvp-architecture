package com.mindorks.framework.mvp.ui.rate.view

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mindorks.framework.mvp.R
import com.mindorks.framework.mvp.ui.base.view.BaseDialogView
import com.mindorks.framework.mvp.ui.rate.interactor.RateUsInterator
import com.mindorks.framework.mvp.ui.rate.presenter.RateUsPresenter
import kotlinx.android.synthetic.main.dialog_rate_us.*
import javax.inject.Inject

/**
 * Created by jyotidubey on 14/01/18.
 */
class RateUsDialog : BaseDialogView(), RateUsDialogView{

    private val TAG = "RateUsDialog"

    @Inject
    internal lateinit var presenter: RateUsPresenter<RateUsDialogView, RateUsInterator>

    companion object {
        private var instance: RateUsDialog? = null
        fun newInstance(): RateUsDialog? {
            if (instance == null) {
                instance = RateUsDialog()
            }
            return instance as RateUsDialog
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_rate_us, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this)
        btnLater.setOnClickListener { presenter.onLaterOptionClicked() }
        btnSubmit.setOnClickListener { presenter.onSubmitOptionClicked() }
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }

    override fun dismissDialog() {
        super.dismissDialog(TAG)

    }

    override fun showRatingSubmissionSuccessMessage() {
        Toast.makeText(context,getString(R.string.rating_submitted_successfully),Toast.LENGTH_LONG).show()
    }

    fun show(fragmentManager: FragmentManager) {
        super.show(fragmentManager, TAG)
    }
}