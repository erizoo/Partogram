package com.boiko.app.ui.parameter

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.text.InputFilter
import android.view.View
import com.boiko.app.R
import com.boiko.app.base.BaseActivity
import com.boiko.app.data.models.RequestTemp
import com.boiko.app.data.models.ResponseFetalHeartbeat
import com.boiko.app.data.models.ResponseStatus
import com.boiko.app.utils.HelpForGraphics
import com.jjoe64.graphview.DefaultLabelFormatter
import kotlinx.android.synthetic.main.activity_parameter.*
import okhttp3.ResponseBody
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class ParameterActivity : BaseActivity(), ParameterMvpView {

    @Inject
    internal lateinit var presenter: ParameterPresenter<ParameterMvpView>

    private var idLabor: Int = 0

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screenComponent?.inject(this)
        presenter.onAttach(this)

        val type = intent.getStringExtra("TYPE")
        val id = intent.getIntExtra("ID", 0)
        idLabor = id

        initView(type)

        abort.setOnClickListener {
            onBackPressed()
        }
        save.setOnClickListener {
            when (type) {
                "Сердцебиение плода" -> {
                    val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                    val date = Date()
                    presenter.fetalHeartbeat(id, edit_text.text.toString(), dateFormat.format(date))
                    edit_text.hint = "Введите количество ударов"
                }
                "Пульс" -> {
                    val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                    val date = Date()
                    presenter.savePulse(id, edit_text.text.toString(), dateFormat.format(date))
                    edit_text.hint = "Введите пульс"
                }
                "Температура тела" -> {
                    val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                    val date = Date()
                    presenter.saveTemp(id, edit_text.text.toString(), dateFormat.format(date))
                    edit_text.hint = "Введите температуру"
                }
                "Давление" -> {
                    val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                    val date = Date()
                    presenter.savePulse(id, edit_text.text.toString(), dateFormat.format(date))
                    edit_text.hint = "Введите давление"
                }
                "Моча" -> {
                    val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                    val date = Date()
                    presenter.savePulse(id, edit_text.text.toString(), dateFormat.format(date))
                }
            }
        }

//        val adapterAmnioticFluid =
//            ArrayAdapter.createFromResource(this, R.array.amniotic_fluid, android.R.layout.simple_spinner_item)
//        adapterAmnioticFluid.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//
//        amniotic_fluid.adapter = adapterAmnioticFluid
//
//        val adapterAmnioticFluidConfig =
//            ArrayAdapter.createFromResource(this, R.array.amniotic_fluid_config, android.R.layout.simple_spinner_item)
//        adapterAmnioticFluidConfig.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//
//        amniotic_fluid_config.adapter = adapterAmnioticFluidConfig
    }

    override fun getContentView(): Int {
        return R.layout.activity_parameter
    }

    override fun onError(errorBody: ResponseBody?) {
        Snackbar.make(edit_text, "Ошибка сохранения", Snackbar.LENGTH_LONG).show()
    }

    override fun onSaved(body: ResponseStatus?) {
        Snackbar.make(edit_text, "Успешно сохранено", Snackbar.LENGTH_LONG).show()
        onBackPressed()
        finish()
    }
    override fun onSavedTemp(body: ResponseStatus?) {
        Snackbar.make(edit_text, "Успешно сохранено", Snackbar.LENGTH_LONG).show()
        onBackPressed()
        finish()
    }

    @SuppressLint("SimpleDateFormat")
    override fun onFetalHeartbeat(body: List<ResponseFetalHeartbeat>?) {
        initGraph()
        val dateBegin = SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(body?.get(0)?.time)
        val dateFinal = SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(body?.get(body.size - 1)?.time)
        graph.viewport.setMinX(dateBegin.time.toDouble())
        graph.viewport.setMaxX(dateFinal.time.toDouble())

        graph.addSeries(HelpForGraphics.getPoints(body))
        graph.viewport.setMinY(0.0)
        graph.viewport.setMaxY(200.0)
    }

    override fun onPulse(body: List<ResponseFetalHeartbeat>?) {
        initGraph()
        val dateBegin = SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(body?.get(0)?.time)
        val dateFinal = SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(body?.get(body.size - 1)?.time)
        graph.viewport.setMinX(dateBegin.time.toDouble())
        graph.viewport.setMaxX(dateFinal.time.toDouble())

        graph.addSeries(HelpForGraphics.getPoints(body))
        graph.viewport.setMinY(60.0)
        graph.viewport.setMaxY(180.0)
    }

    override fun onTemp(body: List<RequestTemp>?) {
        initGraph()
        val dateBegin = SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(body?.get(0)?.time)
        val dateFinal = SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(body?.get(body.size - 1)?.time)
        graph.viewport.setMinX(dateBegin.time.toDouble())
        graph.viewport.setMaxX(dateFinal.time.toDouble())

        graph.addSeries(HelpForGraphics.getPointsTemp(body))
        graph.viewport.setMinY(34.0)
        graph.viewport.setMaxY(43.0)
    }

    private fun initView(type: String?) {
        when {
            type.equals("Сердцебиение плода") -> {
                edit_text2.visibility = View.GONE
                edit_text.hint = "Введите количество ударов"
                title_page.text = "Сердцебиение плода"
                edit_text.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(3))
                presenter.getFetalHeartbeat(idLabor)
            }
            type.equals("Пульс") -> {
                edit_text2.visibility = View.GONE
                edit_text.hint = "Введите пульс"
                title_page.text = "Пульс"
                edit_text.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(3))
                presenter.getPulse(idLabor)
            }
            type.equals("Температура тела") -> {
                edit_text2.visibility = View.GONE
                edit_text.hint = "Введите температуру"
                title_page.text = "Температура"
                presenter.getTemp(idLabor)
            }
        }
    }

    private fun initGraph() {
        val simpleDateFormat = SimpleDateFormat("HH:mm")
        graph.gridLabelRenderer.labelFormatter = object : DefaultLabelFormatter() {
            override fun formatLabel(value: Double, isValueX: Boolean): String {
                return if (isValueX) {
                    simpleDateFormat.format(value)
                } else {
                    super.formatLabel(value, isValueX)
                }
            }
        }
        graph.gridLabelRenderer.numHorizontalLabels = 3
        graph.viewport.isXAxisBoundsManual = true
        graph.viewport.isYAxisBoundsManual = true
        graph.viewport.isScrollable = true
        graph.viewport.isScalable = true
    }

}