package uz.nlg.mega.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import uz.nlg.mega.R
import uz.nlg.mega.ui.theme.MainColor
import uz.nlg.mega.ui.theme.TextColorTextField
import uz.nlg.mega.ui.theme.Color_66
import uz.nlg.mega.ui.theme.TextFieldFillColor
import uz.nlg.mega.ui.theme.TextFieldStrokeColor
import uz.nlg.mega.utils.PADDING_VALUE
import uz.nlg.mega.utils.MainFont
import uz.nlg.mega.views.MainButton
import uz.nlg.mega.views.NextButton
import uz.nlg.mega.views.PasswordTextField
import uz.nlg.mega.views.SimpleTextField
import java.util.Locale

@Destination
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator?
) {

    var login by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .padding(horizontal = PADDING_VALUE)
            .padding(bottom = PADDING_VALUE)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight(0.461F),
                painter = painterResource(id = R.drawable.login_image),
                contentDescription = null,
                contentScale = ContentScale.FillHeight
            )

            Text(
                text = stringResource(id = R.string.str_kirish).uppercase(Locale.getDefault()),
                fontSize = 20.sp,
                fontFamily = MainFont,
                fontWeight = FontWeight.Medium,
                color = Color_66
            )

            Spacer(Modifier.height(16.dp))

            SimpleTextField(
                modifier = Modifier,
                hint = stringResource(id = R.string.str_login),
                text = "",
                backgroundColor = TextFieldFillColor,
                strokeColor = TextFieldStrokeColor,
                textColor = TextColorTextField,
                onChangeListener = {
                    login = it
                }
            )

            Spacer(Modifier.height(16.dp))

            PasswordTextField(
                modifier = Modifier,
                hint = stringResource(id = R.string.str_password),
                text = "",
                backgroundColor = TextFieldFillColor,
                strokeColor = TextFieldStrokeColor,
                textColor = TextColorTextField,
                onChangeListener = {
                    login = it
                }
            )

            Spacer(Modifier.height(32.dp))

            MainButton(
                modifier = Modifier,
                text = stringResource(id = R.string.str_login),
                textColor = Color.White,
                textSize = 16.sp,
                backgroundColor = MainColor,
                strokeColor = MainColor
            ) {

            }

        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(40.dp),
                painter = painterResource(id = R.drawable.mega_logo),
                contentDescription = null,
                contentScale = ContentScale.FillHeight
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginScreen(
        navigator = null
    )
}