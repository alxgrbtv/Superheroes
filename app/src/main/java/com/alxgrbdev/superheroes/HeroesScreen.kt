package com.alxgrbdev.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.alxgrbdev.superheroes.data.Hero
import com.alxgrbdev.superheroes.model.HeroesRepository.heroes

@Composable
fun HeroesList() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        items(heroes) {
            HeroCard(
                hero = it
            )
        }
    }
}

@Composable
fun HeroCard(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = dimensionResource(id = R.dimen.elevation)),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Row(
                modifier = Modifier
            ) {
                Column(
                    modifier = Modifier.weight(9f)
                ) {
                    Text(
                        text = stringResource(id = hero.name),
                        style = MaterialTheme.typography.displaySmall
                    )
                    Text(
                        text = stringResource(id = hero.description),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = hero.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .clip(MaterialTheme.shapes.small)
                )
            }
        }
    }
}

@Preview
@Composable
fun HeroCardPreview() {
    HeroCard(hero = Hero(R.string.hero1, R.string.description1, R.drawable.android_superhero1))
}

@Preview
@Composable
fun HeroesListPreview() {
    HeroesList()
}