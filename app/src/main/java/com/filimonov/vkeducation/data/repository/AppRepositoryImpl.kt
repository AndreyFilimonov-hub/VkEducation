package com.filimonov.vkeducation.data.repository

import com.filimonov.vkeducation.R
import com.filimonov.vkeducation.data.dto.AppDto
import com.filimonov.vkeducation.data.mapper.toEntity
import com.filimonov.vkeducation.domain.entity.App
import com.filimonov.vkeducation.domain.entity.Category
import com.filimonov.vkeducation.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AppRepositoryImpl : AppRepository {

    val apps = listOf(
        AppDto(
            id = 1,
            name = "ChatFlow",
            description = "Общение с друзьями и коллегами",
            category = Category.SOCIAL,
            iconResId = R.drawable.ic_app_v4
        ),
        AppDto(
            id = 2,
            name = "Taskly",
            description = "Планирование задач и ежедневных дел",
            category = Category.PRODUCTIVITY,
            iconResId = R.drawable.ic_app_v3
        ),
        AppDto(
            id = 3,
            name = "MovieBox",
            description = "Фильмы, сериалы и персональные рекомендации",
            category = Category.ENTERTAINMENT,
            iconResId = R.drawable.ic_app_v2
        ),
        AppDto(
            id = 4,
            name = "LearnUp",
            description = "Курсы и материалы для обучения",
            category = Category.EDUCATION,
            iconResId = R.drawable.ic_app_v4
        ),
        AppDto(
            id = 5,
            name = "MoneyTrack",
            description = "Учёт доходов и расходов",
            category = Category.FINANCE,
            iconResId = R.drawable.ic_app_v2
        ),
        AppDto(
            id = 6,
            name = "FitLife",
            description = "Тренировки и отслеживание активности",
            category = Category.HEALTH,
            iconResId = R.drawable.ic_app_v1
        ),
        AppDto(
            id = 7,
            name = "ShopEasy",
            description = "Удобные покупки товаров онлайн",
            category = Category.SHOPPING,
            iconResId = R.drawable.ic_app_v2
        ),
        AppDto(
            id = 8,
            name = "TripGo",
            description = "Планирование поездок и путешествий",
            category = Category.TRAVEL,
            iconResId = R.drawable.ic_app_v4
        ),
        AppDto(
            id = 9,
            name = "FileMaster",
            description = "Управление файлами на устройстве",
            category = Category.TOOLS,
            iconResId = R.drawable.ic_app_v3
        ),
        AppDto(
            id = 10,
            name = "FriendSpace",
            description = "Публикации и общение с друзьями",
            category = Category.SOCIAL,
            iconResId = R.drawable.ic_app_v4
        ),
        AppDto(
            id = 11,
            name = "NoteFlow",
            description = "Заметки, идеи и списки дел",
            category = Category.PRODUCTIVITY,
            iconResId = R.drawable.ic_app_v1
        ),
        AppDto(
            id = 12,
            name = "MusicWave",
            description = "Музыка, плейлисты и любимые треки",
            category = Category.ENTERTAINMENT,
            iconResId = R.drawable.ic_app_v3
        ),
        AppDto(
            id = 13,
            name = "Lingua",
            description = "Изучение иностранных языков",
            category = Category.EDUCATION,
            iconResId = R.drawable.ic_app_v2
        ),
        AppDto(
            id = 14,
            name = "BudgetGo",
            description = "Планирование личного бюджета",
            category = Category.FINANCE,
            iconResId = R.drawable.ic_app_v4
        ),
        AppDto(
            id = 15,
            name = "WeatherNow",
            description = "Прогноз погоды на каждый день",
            category = Category.TOOLS,
            iconResId = R.drawable.ic_app_v2
        )
    )

    override fun getApps(): Flow<List<App>> {
        return flow { apps.forEach(AppDto::toEntity) }
    }
}